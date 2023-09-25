package cn.yiplatform.controller;


import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.dto.BusinessResportDTO;
import cn.yiplatform.entity.BusinessReport;
import cn.yiplatform.service.BusinessReportService;
import cn.yiplatform.service.UserService;
import cn.yiplatform.utils.CommonUtil;
import cn.yiplatform.vo.OperResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
 * @date 2022/3/26-14:34
 */
@RestController
@Transactional
@CrossOrigin
public class BusinessController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DubboReference(interfaceClass = UserService.class, version = "1.0", check = false, timeout = 1800000000)
    private UserService userService;

    @DubboReference(interfaceClass = BusinessReportService.class, version = "1.0", check = false, timeout = 1800000000)
    private BusinessReportService businessReportService;


    @Value("${business.column.name}")
    private String businessColumnName;

    /**
     * 获取出差报告，idStr为空时查询所有记录
     * @param uidStr
     * @return
     */
    @GetMapping("/business")
    public OperResult getBusinessReportByIds(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10")Integer pageSize,
                                             String uidStr,
                                             String beginDate,
                                             String endDate,
                                             @RequestParam(defaultValue = "") String account,
                                             Integer status){
        List<Long> idList = new ArrayList<>();
        Page<BusinessReport> businessReportList;
        OperResult operResult;
        try {
            if (StringUtils.isNotEmpty(uidStr)){
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
            businessReportList = businessReportService.getBusinessReport(new Page<>(pageNum, pageSize), idList, beginTime, endTime, account, status);
            operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取出差记录成功", businessReportList);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取出差记录失败", SysContants.NULL);
            logger.error("/business 请求报错", e);
        }
        return operResult;
    }

    /**
     * 更新出差报告
     * @param businessResportDTO
     * @return
     */
    @PostMapping("/updateBusinessReport")
    public OperResult updateBusinessReport(@RequestBody BusinessResportDTO businessResportDTO) {
        if (Objects.isNull(businessResportDTO)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "请求异常", Boolean.FALSE);
        }
        // 先判断报告id或更新内容是否为空，任一为空则返回失败
        if (Objects.isNull(businessResportDTO.getId())) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "报告id不能为空", Boolean.FALSE);
        }
        // 校验出发地与目的地
        if (StringUtils.isNotEmpty(businessResportDTO.getStartPlace())
                && StringUtils.isNotEmpty(businessResportDTO.getEndPlace())
                && StringUtils.equals(businessResportDTO.getStartPlace(), businessResportDTO.getEndPlace())){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "出发地与目的地不能相同", Boolean.FALSE);
        }
        // 要更新的key -> value
        Map<String, Object> updateWrapper;
        OperResult operResult;
        try {
            // 获取修改内容
            updateWrapper = CommonUtil.getObjFieldNameAndValue(businessResportDTO);
            if (MapUtils.isEmpty(updateWrapper)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"修改内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = businessReportService.updateBusinessReport(businessResportDTO.getId(), updateWrapper);
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "更新出差报告成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新出差报告失败", Boolean.FALSE) ;
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新出差报告异常", Boolean.FALSE);
            logger.error("updateBusinessReport 更新出差报告出错", e);
        }
        return operResult;
    }

    /**
     * 修改出差记录的状态
     * @param businessReport
     * @return
     */
    @PostMapping("/alterBusinessReport")
    public OperResult alterBusinessReport(@RequestBody BusinessReport businessReport){
        OperResult operResult;
        try {
            if (Objects.isNull(businessReport.getId())){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "出差报告id不能为空", Boolean.FALSE);
            }
            Boolean updateResult = businessReportService.alterBusinessReport(businessReport.getId(), businessReport.getStatus());
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "修改出差记录状态成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "修改出差记录状态失败", Boolean.FALSE) ;

        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "修改出差记录状态异常", Boolean.FALSE);
            logger.error("修改出差记录状态 alterBusinessReport 异常", e);
        }
        return operResult;
    }

    /**
     * 搜索出差记录
     * @param pageNum
     * @param pageSize
     * @param account
     * @return
     */
    @GetMapping("/queryBusinessReport")
    public OperResult searchBusinessReportByAccount(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(defaultValue = "") String account) {
        Page<BusinessReport> businessReportPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索出差记录失败", Boolean.FALSE);
        if (Objects.isNull(account)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
        }
        try {
            businessReportPage = businessReportService.searchBusinessReportByAccount(new Page<>(pageNum, pageSize), account);
            if (!Objects.isNull(businessReportPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "搜索出差记录成功", businessReportPage);
            }
        } catch (Exception e) {
            logger.error("模糊查询出差记录 searchBusinessReportByAccount 异常", e);
        }
        return operResult;
    }

    /**
     * 新增出差记录
     * @param businessResportDTO
     * @return
     */
    @PostMapping("/addBusinessReport")
    public OperResult addBusinessReport(@RequestBody BusinessResportDTO businessResportDTO){
        OperResult operResult;
        try {
            if (Objects.isNull(businessResportDTO)){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增内容不能为空", Boolean.FALSE);
            }
            Map<String, Object> addContent = CommonUtil.getObjFieldNameAndValue(businessResportDTO);
            // 必填字段为空，操作失败
            Map<String, Object> emptyColumnMap = CommonUtil.getEmptyColumnMap(businessColumnName, addContent);
            for (String key : emptyColumnMap.keySet()) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), emptyColumnMap.get(key) + "内容不能为空", Boolean.FALSE);
            }
            // 将dto转为entity
            String jsonStr = CommonUtil.getContentInBrace(JSONObject.toJSONString(businessResportDTO));
            BusinessReport businessReport = JSON.parseObject(jsonStr, BusinessReport.class);
            // 开始新增
            Boolean updateResult = businessReportService.addBusinessReport(businessReport);
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "新增出差记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增出差记录失败", Boolean.FALSE) ;

        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增出差记录异常", Boolean.FALSE);
            logger.error("新增出差记录 addBusinessReport 异常", e);
        }
        return operResult;
    }
}
