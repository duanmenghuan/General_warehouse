package cn.yiplatform.mapper;
import cn.yiplatform.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import cn.yiplatform.entity.TemperatureReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
*
* @description 针对表【temperature_report】的数据库操作Mapper
* @createDate 2022-03-09 10:03:43
* @Entity cn.yiplatform.entity.HealthyReport
*/
public interface TemperatureReportMapper extends BaseMapper<TemperatureReport> {

    // 根据用户id查询体温报告
    Page<TemperatureReport> selectAllByIds(Page<TemperatureReport> page, List<Long> idList);

    // 查询所有的体温提交记录(分页)
    Page<TemperatureReport> selectAll(Page<TemperatureReport> page);

    // 根据账号模糊查询健康报告
    Page<TemperatureReport> selectAllLikeAccount(Page<TemperatureReport> page, String account);

    // 根据日期区间查询健康报告
    Page<TemperatureReport> selectAllByAccountAndSubmitTimeBetween(Page<TemperatureReport> page, List<Long> idList, @Param("beginSubmitTime") Date beginSubmitTime, @Param("endSubmitTime") Date endSubmitTime);

    Page<TemperatureReport> selectAllByWrappers(Page<TemperatureReport> page, List<Long> idList, @Param("beginSubmitTime") Date beginSubmitTime, @Param("endSubmitTime") Date endSubmitTime, String account);

    // 根据体温数据填写状态查询员工
    Page<TemperatureReport> selectAllByFillStatus(Page<TemperatureReport> page, @Param("fillStatus") Integer fillStatus);

    // 查询体温异常(>=37.3)的数据
    Page<TemperatureReport> selectAbnormalTempData(Page<TemperatureReport> page);
}




