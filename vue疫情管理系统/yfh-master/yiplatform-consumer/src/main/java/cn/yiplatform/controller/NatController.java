package cn.yiplatform.controller;

import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.entity.NatReport;
import cn.yiplatform.service.NatReportService;
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
 * @date 2022/3/27-14:19
 */
@RestController
@Transactional
@CrossOrigin
public class NatController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DubboReference(interfaceClass = UserService.class, version = "1.0", check = false, timeout = 1800000000)
    private UserService userService;

    @DubboReference(interfaceClass = NatReportService.class, version = "1.0", check = false, timeout = 1800000000)
    private NatReportService natReportService;

    @Value("${nat.column.name}")
    private String natColumnName;

    /**
     * 获取核酸检测记录，idStr为空时查询所有记录
     * @param uidStr
     * @return
     */
    @GetMapping("/nat")
    public OperResult getNatReportByIds(@RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "10")Integer pageSize,
                                         String uidStr,
                                         String beginDate,
                                         String endDate,
                                         @RequestParam(defaultValue = "") String account){
        List<Long> idList = new ArrayList<>();
        Page<NatReport> natReportList;
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
            // 获取核酸检测记录
            natReportList = natReportService.getNatReport(new Page<>(pageNum, pageSize), idList, beginTime, endTime, account);
            operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取核酸检测记录成功", natReportList);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取核酸检测记录失败", SysContants.NULL);
            logger.error("/nat 请求报错", e);
        }
        return operResult;
    }

    /**
     * 更新核酸检测记录
     * @param natReport
     * @return
     */
    @PostMapping("/updateNatReport")
    public OperResult updateNatReport(@RequestBody NatReport natReport) {
        // 先判断用户id或更新内容是否为空，任一为空则返回失败
        if (Objects.isNull(natReport.getId())) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "用户id不能为空", Boolean.FALSE);
        }
        // 要更新的key -> value
        Map<String, Object> updateWrapper;
        OperResult operResult;
        try {
            // 获取修改内容
            updateWrapper = CommonUtil.getObjFieldNameAndValue(natReport);
            if (MapUtils.isEmpty(updateWrapper)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"修改内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = natReportService.updateNatReport(natReport.getId(), updateWrapper);
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "更新核酸检测记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新核酸检测记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新核酸检测记录异常", Boolean.FALSE);
            logger.error("updateNatReport 更新核酸检测记录出错", e);
        }
        return operResult;
    }

    /**
     * 搜索核酸检测记录
     * @param pageNum
     * @param pageSize
     * @param account
     * @return
     */
    @GetMapping("/queryNatReport")
    public OperResult searchNatReportByAccount(@RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "") String account) {
        Page<NatReport> natReportPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索核酸检测记录失败", Boolean.FALSE);
        if (Objects.isNull(account)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
        }
        try {
            natReportPage = natReportService.searchNatReportByAccount(new Page<>(pageNum, pageSize), account);
            if (!Objects.isNull(natReportPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "搜索出差记录成功", natReportPage);
            }
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
            logger.error("模糊查询核酸检测记录 searchNatReportByAccount 异常", e);
        }
        return operResult;
    }


    /**
     * 新增核酸检测记录
     * @param natReport
     * @return
     */
    @PostMapping("/addNatReport")
    public OperResult addNatReport(@RequestBody NatReport natReport){
        OperResult operResult;
        try {
            if (Objects.isNull(natReport)){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增内容不能为空", Boolean.FALSE);
            }
            Map<String, Object> addContentMap = CommonUtil.getObjFieldNameAndValue(natReport);
            // 必填字段为空，操作失败
            Map<String, Object> emptyColumnMap = CommonUtil.getEmptyColumnMap(natColumnName, addContentMap);
            for (String key : emptyColumnMap.keySet()) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), emptyColumnMap.get(key) + "内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = natReportService.addNatReport(natReport);
            if (updateResult) {
                updateResult = userService.updateFillStatus(natReport.getUid());
            }
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "新增核酸检测记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增核酸检测记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增核酸检测记录异常", Boolean.FALSE);
            logger.error("新增核酸检测记录 addNatReport 异常", e);
        }
        return operResult;
    }
}
