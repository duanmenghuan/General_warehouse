package cn.yiplatform.mapper;

import cn.yiplatform.entity.NatReport;
import cn.yiplatform.entity.VaccinationRecord;
import cn.yiplatform.entity.VaccinationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javafx.scene.chart.ValueAxis;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
*
* @description 针对表【vaccination_record(疫苗接种记录)】的数据库操作Mapper
* @createDate 2022-03-27 13:42:28
* @Entity cn.yiplatform.entity.VaccinationRecord
*/
public interface VaccinationRecordMapper extends BaseMapper<VaccinationRecord> {

    // 根据用户id查询出差记录
    Page<VaccinationRecord> selectAllByIds(Page<VaccinationRecord> page, List<Long> idList);

    // 查询所有的出差记录
    Page<VaccinationRecord> selectAll(Page<VaccinationRecord> page);

    // 根据用户账号模糊查询出差记录
    Page<VaccinationRecord> selectAllLikeAccount(Page<VaccinationRecord> page, String account);

    // 根据创建日期区间查询出差记录
    Page<VaccinationRecord> selectAllByAccountAndCreateTimeBetween(Page<VaccinationRecord> page, List<Long> idList, @Param("beginCreateTime") Date beginCreateTime, @Param("endCreateTime") Date endCreateTime);

    Page<VaccinationRecord> selectAllByWrappers(Page<VaccinationRecord> page, List<Long> idList, @Param("beginSubmitTime") Date beginSubmitTime, @Param("endSubmitTime") Date endSubmitTime, String account);
}




