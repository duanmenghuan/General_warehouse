package cn.yiplatform.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
import cn.yiplatform.entity.BusinessReport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
*
* @description 针对表【business_report(员工出差报备信息表)】的数据库操作Mapper
* @createDate 2022-03-09 10:03:20
* @Entity cn.yiplatform.entity.BusinessReport
*/
public interface BusinessReportMapper extends BaseMapper<BusinessReport> {

    // 根据用户id查询出差记录
    Page<BusinessReport> selectAllByIds(Page<BusinessReport> page, List<Long> idList);

    // 查询所有的出差记录
    Page<BusinessReport> selectAll(Page<BusinessReport> page);

    // 根据用户账号模糊查询出差记录
    Page<BusinessReport> selectAllLikeAccount(Page<BusinessReport> page, String account);

    // 根据创建日期区间查询出差记录
    Page<BusinessReport> selectAllByAccountAndCreateTimeBetween(Page<BusinessReport> page, List<Long> idList, @Param("beginCreateTime") Date beginCreateTime, @Param("endCreateTime") Date endCreateTime);

    Page<BusinessReport> selectAllByWrappers(Page<BusinessReport> page, List<Long> idList, @Param("beginSubmitTime") Date beginSubmitTime, @Param("endSubmitTime") Date endSubmitTime, String account, Integer status);

    BusinessReport selectByReportId(Long reportId);
}




