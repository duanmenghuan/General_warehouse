package cn.yiplatform.controller;

import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.entity.BusinessReport;
import cn.yiplatform.entity.TeleWorkRecord;
import cn.yiplatform.service.TeleWorkRecordService;
import cn.yiplatform.service.UserService;
import cn.yiplatform.utils.CommonUtil;
import cn.yiplatform.vo.OperResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @date 2022/3/27-22:47
 */
@RestController
@Transactional
@CrossOrigin
public class TeleWorkRecordController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DubboReference(interfaceClass = UserService.class, version = "1.0", check = false, timeout = 1800000000)
    private UserService userService;

    @DubboReference(interfaceClass = TeleWorkRecordService.class, version = "1.0", check = false, timeout = 1800000000)
    private TeleWorkRecordService teleWorkRecordService;

    @Value("${tele.work.column.name}")
    private String teleWorkColumnName;

    /**
     * 获取远程办公记录，idStr为空时查询所有记录
     * @param uidStr
     * @return
     */
    @GetMapping("/telework")
    public OperResult getTeleWorkRecordByIds(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10")Integer pageSize,
                                        String uidStr,
                                        String beginDate,
                                        String endDate,
                                        @RequestParam(defaultValue = "") String account,
                                        Integer status){
        List<Long> idList = new ArrayList<>();
        Page<TeleWorkRecord> teleWorkRecordList;
        OperResult operResult;
        try {
            if (StringUtils.isNotEmpty(uidStr)){
                // 处理前端传的参数，组成id列表
                String[] strings = uidStr.split(",");
                for (String s : strings) {
                    idList.add(Long.parseLong(s));
                }
            }

            // String转换成Date
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date beginTime = null;
            Date endTime = null;
            if (StringUtils.isNotEmpty(beginDate)) {
                beginTime = ft.parse(ft.format(Long.parseLong(beginDate)));
            }
            if (StringUtils.isNotEmpty(endDate)) {
                endTime = ft.parse(ft.format(Long.parseLong(endDate)));
            }
            // 获取远程办公记录
            teleWorkRecordList = teleWorkRecordService.getTeleWorkRecord(new Page<>(pageNum, pageSize), idList, beginTime, endTime, account, status);
            operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取远程办公记录成功", teleWorkRecordList);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取远程办公记录失败", SysContants.NULL);
            logger.error("/telework 请求报错", e);
        }
        return operResult;
    }

    /**
     * 更新远程办公记录
     * @param teleWorkRecord
     * @return
     */
    @PostMapping("/updateTeleWorkRecord")
    public OperResult updateTeleWorkRecord(@RequestBody TeleWorkRecord teleWorkRecord) {
        // 先判断用户id或更新内容是否为空，任一为空则返回失败
        if (Objects.isNull(teleWorkRecord.getId())) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "用户id不能为空", Boolean.FALSE);
        }
        // 要更新的key -> value
        Map<String, Object> updateWrapper;
        OperResult operResult;
        try {
            // 获取修改内容
            updateWrapper = CommonUtil.getObjFieldNameAndValue(teleWorkRecord);
            if (MapUtils.isEmpty(updateWrapper)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"修改内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = teleWorkRecordService.updateTeleWorkRecord(teleWorkRecord.getId(), updateWrapper);
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "更新远程办公记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新远程办公记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新远程办公记录异常", Boolean.FALSE);
            logger.error("updateTeleWorkRecord 更新远程办公记录出错", e);
        }
        return operResult;
    }

    /**
     * 根据账号搜索远程办公记录
     * @param pageNum
     * @param pageSize
     * @param account
     * @return
     */
    @GetMapping("/queryTeleWorkRecord")
    public OperResult searchTeleWorkRecordByAccount(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam(defaultValue = "") String account) {
        Page<TeleWorkRecord> teleWorkRecordPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索远程办公记录失败", Boolean.FALSE);
        if (Objects.isNull(account)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
        }
        try {
            teleWorkRecordPage = teleWorkRecordService.searchTeleWorkRecordByAccount(new Page<>(pageNum, pageSize), account);
            if (!Objects.isNull(teleWorkRecordPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "搜索远程办公记录成功", teleWorkRecordPage);
            }
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
            logger.error("模糊查询远程办公记录 searchTeleWorkRecordByAccount 异常", e);
        }
        return operResult;
    }


    /**
     * 新增远程办公记录
     * @param teleWorkRecord
     * @return
     */
    @PostMapping("/addTeleWorkRecord")
    public OperResult addTeleWorkRecord(@RequestBody TeleWorkRecord teleWorkRecord){
        OperResult operResult;
        try {
            if (Objects.isNull(teleWorkRecord)){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增内容不能为空", Boolean.FALSE);
            }
            Map<String, Object> addContentMap = CommonUtil.getObjFieldNameAndValue(teleWorkRecord);
            // 必填字段为空，操作失败
            Map<String, Object> emptyColumnMap = CommonUtil.getEmptyColumnMap(teleWorkColumnName, addContentMap);
            for (String key : emptyColumnMap.keySet()) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), emptyColumnMap.get(key) + "内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = teleWorkRecordService.addTeleWorkRecord(teleWorkRecord);
            if (updateResult) {
                updateResult = userService.updateFillStatus(teleWorkRecord.getUid());
            }
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "新增远程办公记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增远程办公记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增远程办公记录异常", Boolean.FALSE);
            logger.error("新增远程办公记录 addTeleWorkRecord 异常", e);
        }
        return operResult;
    }

    /**
     * 修改远程办公记录的状态
     * @param teleWorkRecord
     * @return
     */
    @PostMapping("/alterTeleWordStatus")
    public OperResult alterTeleWordStatus(@RequestBody TeleWorkRecord teleWorkRecord){
        OperResult operResult;
        try {
            if (Objects.isNull(teleWorkRecord.getId())){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "远程办公记录id不能为空", Boolean.FALSE);
            }
            Boolean updateResult = teleWorkRecordService.alterTeleWorkStatus(teleWorkRecord.getId(), teleWorkRecord.getStatus());
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "修改远程办公记录状态成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "修改远程办公记录状态失败", Boolean.FALSE) ;

        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "修改远程办公记录状态异常", Boolean.FALSE);
            logger.error("修改远程办公记录状态 alterTeleWordStatus 异常", e);
        }
        return operResult;
    }
}
