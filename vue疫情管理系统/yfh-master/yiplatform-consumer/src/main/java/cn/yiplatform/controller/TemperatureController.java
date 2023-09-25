package cn.yiplatform.controller;

import cn.yiplatform.contants.ResponseStatusCode;
import cn.yiplatform.contants.SysContants;
import cn.yiplatform.dto.TemperatureReportDTO;
import cn.yiplatform.entity.TemperatureReport;
import cn.yiplatform.service.TemperatureReportService;
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
 * @date 2022/3/9-10:08
 */
@RestController
@Transactional
@CrossOrigin
public class TemperatureController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DubboReference(interfaceClass = UserService.class, version = "1.0", check = false, timeout = 1800000000)
    private UserService userService;
    
    @DubboReference(interfaceClass = TemperatureReportService.class, version = "1.0", check = false, timeout = 1800000000)
    private TemperatureReportService temperatureReportService;
    
    @Value("${temperature.column.name}")
    private String temperatureColumnName;
    

    /**
     * 获取体温报告，idStr为空时查询所有记录
     * @param uidStr
     * @return
     */
    @GetMapping("/temp")
    public OperResult getTempReportByIds(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10")Integer pageSize,
                                          @RequestParam(defaultValue = "true") Boolean isPage,
                                          String uidStr,
                                          String beginDate,
                                          String endDate,
                                          @RequestParam(defaultValue = "") String account){
        List<Long> idList = new ArrayList<>();
        Page<TemperatureReport> tempReportList;
        OperResult operResult;
        try {
            if (StringUtils.isNotEmpty(uidStr)){
                // 处理前端传的参数，组成id列表
                String[] strings = uidStr.split(",");
                for (String s : strings) {
                    idList.add(Long.parseLong(s));
                }
            }

            if (!isPage) {
                pageSize = 1000000;
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
            // 获取体温报告
            tempReportList = temperatureReportService.getTempReport(new Page<>(pageNum, pageSize), idList, beginTime, endTime, account);
            operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取体温报告成功", tempReportList);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取体温报告失败", SysContants.NULL);
            logger.error("/temp  getTempReportByIds请求报错", e);
        }
        return operResult;
    }

    /**
     * 更新体温记录
     * @param temperatureReportDTO
     * @return
     */
    @PostMapping("/updateTempReport")
    public OperResult updateTempReport(@RequestBody TemperatureReportDTO temperatureReportDTO) {
        // 先判断用户id或更新内容是否为空，任一为空则返回失败
        if (Objects.isNull(temperatureReportDTO.getId())) {
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "用户id不能为空", Boolean.FALSE);
        }
        // 要更新的key -> value
        Map<String, Object> updateWrapper;
        OperResult operResult;
        try {
            // 获取修改内容
            updateWrapper = CommonUtil.getObjFieldNameAndValue(temperatureReportDTO);
            if (MapUtils.isEmpty(updateWrapper)) {
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(),"修改内容不能为空", Boolean.FALSE);
            }
            Boolean updateResult = temperatureReportService.updateTempReport(temperatureReportDTO.getId(), updateWrapper);
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "更新体温报告成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新体温报告失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "更新体温报告异常", Boolean.FALSE);
            logger.error("updateBusinessReport 更新体温报告出错", e);
        }
        return operResult;
    }

    /**
     * 搜索体温记录
     * @param pageNum
     * @param pageSize
     * @param account
     * @return
     */
    @GetMapping("/queryTempReport")
    public OperResult searchTempReportByAccount(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(defaultValue = "") String account) {
        Page<TemperatureReport> healthyReportPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索体温记录失败", Boolean.FALSE);
        if (Objects.isNull(account)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
        }
        try {
            healthyReportPage = temperatureReportService.searchTempReportByAccount(new Page<>(pageNum, pageSize), account);
            if (!Objects.isNull(healthyReportPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "搜索出差记录成功", healthyReportPage);
            }
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "搜索内容异常", Boolean.FALSE);
            logger.error("模糊查询体温记录 searchTempReportByAccount 异常", e);
        }
        return operResult;
    }


    /**
     * 新增体温记录
     * @param temperatureReportDTO
     * @return
     */
    @PostMapping("/addTempReport")
    public OperResult addTempReport(@RequestBody TemperatureReportDTO temperatureReportDTO){
        OperResult operResult;
        try {
            if (Objects.isNull(temperatureReportDTO)){
                return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增内容不能为空", Boolean.FALSE);
            }
            Map<String, Object> addContentMap = CommonUtil.getObjFieldNameAndValue(temperatureReportDTO);
            // 必填字段为空，操作失败
            Map<String, Object> emptyColumnMap = CommonUtil.getEmptyColumnMap(temperatureColumnName, addContentMap);
            for (String key : emptyColumnMap.keySet()) {
               return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), emptyColumnMap.get(key) + "内容不能为空", Boolean.FALSE);
            }
            // 将dto转为entity
            String jsonStr = CommonUtil.getContentInBrace(JSONObject.toJSONString(temperatureReportDTO));
            TemperatureReport temperatureReport = JSON.parseObject(jsonStr, TemperatureReport.class);
            Boolean updateResult = temperatureReportService.addTempReport(temperatureReport);
            if (updateResult) {
                updateResult = userService.updateFillStatus(temperatureReportDTO.getUid());
            }
            operResult = updateResult ? new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "新增体温记录成功", Boolean.TRUE)
                    : new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增体温记录失败", Boolean.FALSE);
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "新增体温记录异常", Boolean.FALSE);
            logger.error("新增体温记录 addBusinessReport 异常", e);
        }
        return operResult;
    }

    /**
     * 搜索体温记录
     * @param pageNum
     * @param pageSize
     * @param fillStatus
     * @return
     */
    @GetMapping("/getTempReportByFillStatus")
    public OperResult getTempReportByFillStatus(@RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "1") Integer fillStatus) {
        Page<TemperatureReport> tempReportPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取员工填报记录失败", Boolean.FALSE);
        if (Objects.isNull(fillStatus)){
            return new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "参数异常", Boolean.FALSE);
        }
        try {
            tempReportPage = temperatureReportService.getTodayFillStatusEmployee(new Page<>(pageNum, pageSize), fillStatus);
            if (!Objects.isNull(tempReportPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取员工填报记录成功", tempReportPage);
            }
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取员工填报记录异常", Boolean.FALSE);
            logger.error("获取员工填报记录 getTempReportByFillStatus 异常", e);
        }
        return operResult;
    }

    /**
     * 获取异常体温的记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getAbnormalTempData")
    public OperResult getAbnormalTempData(@RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<TemperatureReport> abnormalTempReportPage;
        OperResult operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取异常体温数据失败", Boolean.FALSE);
        try {
            abnormalTempReportPage = temperatureReportService.getAbnormalTempData(new Page<>(pageNum, pageSize));
            if (!Objects.isNull(abnormalTempReportPage)){
                operResult = new OperResult(OperResult.OPER_SUCCESS, ResponseStatusCode.OK.getCode(), "获取异常体温数据成功", abnormalTempReportPage);
            }
        } catch (Exception e) {
            operResult = new OperResult(OperResult.OPER_FAILURE, ResponseStatusCode.NO.getCode(), "获取异常体温数据异常", Boolean.FALSE);
            logger.error("获取异常体温数据 getAbnormalTempData 异常", e);
        }
        return operResult;
    }
}
