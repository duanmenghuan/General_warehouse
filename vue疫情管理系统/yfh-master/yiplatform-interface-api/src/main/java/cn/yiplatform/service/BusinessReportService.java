package cn.yiplatform.service;

import cn.yiplatform.entity.BusinessReport;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【business_report(员工出差报备信息表)】的数据库操作Service
* @createDate 2022-03-09 10:03:20
*/
@Repository
public interface BusinessReportService extends IService<BusinessReport> {

    /**
     * 根据id查出差记录，idList为空时查询所有记录
     * @param idList
     * @param account
     * @return
     */
    Page<BusinessReport> getBusinessReport(Page<BusinessReport> page, List<Long> idList, Date beginDate, Date endDate, String account, Integer status);

    /**
     * 根据用户id  更新用户修改的出差信息
     * @param id
     * @param wrapper
     * @return
     */
    Boolean updateBusinessReport(Long id, Map<String, Object> wrapper);

    /**
     * 根据出差报告id修改出差报告状态
     * @param id
     * @return
     */
    Boolean alterBusinessReport(Long id, int statusCode);

    /**
     * 根据用户账号模糊查询出差记录
     * @param page
     * @param account
     * @return
     */
    Page<BusinessReport> searchBusinessReportByAccount(Page<BusinessReport> page, String account);

    /**
     * 新增出差记录
     * @param businessReport
     * @return
     */
    Boolean addBusinessReport(BusinessReport businessReport);
}
