package cn.yiplatform.controller;

import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.entity.VaccinationRecord;
import cn.yiplatform.service.UserService;
import cn.yiplatform.service.VaccinationRecordService;
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
 * @date 2022/3/27-14:20
 */
@RestController
@Transactional
@CrossOrigin
public class VaccinationRecordController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DubboReference(interfaceClass = UserService.class, version = "1.0", check = false, timeout = 1800000000)
    private UserService userService;

    @DubboReference(interfaceClass = VaccinationRecordService.class, version = "1.0", check = false, timeout = 1800000000)
    private VaccinationRecordService vaccinationRecordService;

    @Value("${vaccination.column.name}")
    private String vaccinationColumnName;

    /**
     * 获取疫苗接种记录，idStr为空时查询所有记录
     * @param uidStr
     * @return
     */
    @GetMapping("/vaccination")
    public OperResult getNatReportByIds(@RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10")Integer pageSize,
                                        String uidStr,
                                        String beginDate,
                                        String endDate,
                                        @RequestParam(defaultValue = "") String account){
        List<Long> idList = new ArrayList<>();
        Page<VaccinationRecord> vaccinationRecordList;
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
            // 获取疫苗接种记录
            vaccinationRecordList = vaccinationRecordService.getVaccinationRecord(new Page<>(pageNum, pageSize), idList, beginTime, endTime, account);
            operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取疫苗接种记录成功", vaccinationRecordList);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取疫苗接种记录失败", SysContants.NULL);
            logger.error("/vaccination 请求报错", e);
        }
        return operResult;
    }

    /**
     * 更新疫苗接种记录
     * @param vaccinationRecord
     * @return
     */
    @PostMapping("/updateVaccinationRecord")
    public OperResult updateNatReport(@RequestBody VaccinationRecord vaccinationRecord) {
        // 先判断用户id或更新内容是否为空，任一为空则返回失败
        if (Objects.isNull(vaccinationRecord.getId())) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "用户id不能为空", Boolean.FALSE);
        }
        // 要更新的key -> value
        Map<String, Object> updateWrapper;
        OperResult operResult;
        try {
            // 获取修改内容
            updateWrapper = CommonUtil.getObjFieldNameAndValue(vaccinationRecord);
            if (MapUtils.isEmpty(updateWrapper)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"修改内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = vaccinationRecordService.updateVaccinationRecord(vaccinationRecord.getId(), updateWrapper);
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "更新疫苗接种记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新疫苗接种记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新疫苗接种记录异常", Boolean.FALSE);
            logger.error("updateVaccinationRecord更新疫苗接种记录出错", e);
        }
        return operResult;
    }

    /**
     * 搜索疫苗接种记录
     * @param pageNum
     * @param pageSize
     * @param account
     * @return
     */
    @GetMapping("/queryVaccinationRecordReport")
    public OperResult searchNatReportByAccount(@RequestParam(defaultValue = "1") Integer pageNum,
                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                               @RequestParam(defaultValue = "") String account) {
        Page<VaccinationRecord>natReportPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索疫苗接种记录失败", Boolean.FALSE);
        if (Objects.isNull(account)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
        }
        try {
            natReportPage = vaccinationRecordService.searchVaccinationRecordByAccount(new Page<>(pageNum, pageSize), account);
            if (!Objects.isNull(natReportPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "搜索出差记录成功", natReportPage);
            }
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
            logger.error("模糊查询疫苗接种记录 searchNatReportByAccount 异常", e);
        }
        return operResult;
    }


    /**
     * 新增疫苗接种记录
     * @param vaccinationRecord
     * @return
     */
    @PostMapping("/addVaccinationRecord")
    public OperResult addNatReport(@RequestBody VaccinationRecord vaccinationRecord){
        OperResult operResult;
        try {
            if (Objects.isNull(vaccinationRecord)){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增内容不能为空", Boolean.FALSE);
            }
            Map<String, Object> addContentMap = CommonUtil.getObjFieldNameAndValue(vaccinationRecord);
            // 必填字段为空，操作失败
            Map<String, Object> emptyColumnMap = CommonUtil.getEmptyColumnMap(vaccinationColumnName, addContentMap);
            for (String key : emptyColumnMap.keySet()) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), emptyColumnMap.get(key) + "内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = vaccinationRecordService.addVaccinationRecord(vaccinationRecord);
            if (updateResult) {
                updateResult = userService.updateFillStatus(vaccinationRecord.getUid());
            }
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "新增疫苗接种记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增疫苗接种记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增疫苗接种记录异常", Boolean.FALSE);
            logger.error("新增疫苗接种记录 addVaccinationRecord异常", e);
        }
        return operResult;
    }
}
