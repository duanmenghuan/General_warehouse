package cn.yiplatform.mapper;

import cn.yiplatform.entity.NatReport;
import cn.yiplatform.entity.TemperatureReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
*
* @description 针对表【nat_report(核酸检测报告)】的数据库操作Mapper
* @createDate 2022-03-27 13:42:28
* @Entity cn.yiplatform.entity.NatReport
*/
public interface NatReportMapper extends BaseMapper<NatReport> {
    // 根据用户id查询核酸检测记录
    Page<NatReport> selectAllByIds(Page<NatReport> page, List<Long> idList);

    // 查询所有的核酸检测记录
    Page<NatReport> selectAll(Page<NatReport> page);

    // 根据用户账号模糊查询核酸检测记录
    Page<NatReport> selectAllLikeAccount(Page<NatReport> page, String account);

    // 根据创建日期区间查询核酸检测记录
    Page<NatReport> selectAllByIdsAndCreateTimeBetween(Page<NatReport> page, List<Long> idList, @Param("beginCreateTime") Date beginCreateTime, @Param("endCreateTime") Date endCreateTime);

    Page<NatReport> selectAllByWrappers(Page<NatReport> page, List<Long> idList, @Param("beginSubmitTime") Date beginSubmitTime, @Param("endSubmitTime") Date endSubmitTime, String account);
}




