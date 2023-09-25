package cn.yiplatform.service;

import cn.yiplatform.entity.NatReport;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【nat_report(核酸检测报告)】的数据库操作Service
* @createDate 2022-03-27 13:42:28
*/
public interface NatReportService extends IService<NatReport> {

    /**
     * 根据id查询核酸检测记录，idList为空时查询所有记录
     * @param idList
     * @param beginDate
     * @param endDate
     * @param account
     * @return
     */
    Page<NatReport> getNatReport(Page<NatReport> page, List<Long> idList, Date beginDate, Date endDate, String account);

    /**
     * 根据用户id  更新用户修改的核酸检测记录
     * @param id
     * @param wrapper
     * @return
     */
    Boolean updateNatReport(Long id, Map<String, Object> wrapper);

    /**
     * 根据用户账号模糊查询核酸检测记录
     * @param page
     * @param account
     * @return
     */
    Page<NatReport> searchNatReportByAccount(Page<NatReport> page, String account);

    /**
     * 新增核酸检测记录
     * @param natReport
     * @return
     */
    Boolean addNatReport(NatReport natReport);

}
