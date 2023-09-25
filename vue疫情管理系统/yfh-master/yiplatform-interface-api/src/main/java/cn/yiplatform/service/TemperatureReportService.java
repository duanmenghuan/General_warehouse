package cn.yiplatform.service;

import cn.yiplatform.entity.TemperatureReport;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【temperature_report】的数据库操作Service
* @createDate 2022-03-09 10:03:43
*/
public interface TemperatureReportService extends IService<TemperatureReport> {

    /**
     * 根据条件查询健康报告，条件为空时查询所有记录
     * @param idList
     * @param beginDate
     * @param endDate
     * @param account
     * @return
     */
    Page<TemperatureReport> getTempReport(Page<TemperatureReport> page, List<Long> idList, Date beginDate, Date endDate, String account);

    /**
     * 根据用户id  更新用户修改的健康信息
     * @param id
     * @param wrapper
     * @return
     */
    Boolean updateTempReport(Long id, Map<String, Object> wrapper);

    /**
     * 根据用户账号模糊查询健康记录
     * @param page
     * @param account
     * @return
     */
    Page<TemperatureReport> searchTempReportByAccount(Page<TemperatureReport> page, String account);

    /**
     * 新增健康记录
     * @param temperatureReport
     * @return
     */
    Boolean addTempReport(TemperatureReport temperatureReport);

    /**
     * 查询今天填报(未填报)的员工相关信息
     * @param page
     * @param fillStatus
     * @return
     */
    Page<TemperatureReport> getTodayFillStatusEmployee(Page<TemperatureReport> page, Integer fillStatus);

    /**
     * 查询体温异常的体温数据
     * @param page
     * @return
     */
    Page<TemperatureReport> getAbnormalTempData(Page<TemperatureReport> page);

}
