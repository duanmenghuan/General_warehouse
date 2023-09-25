package cn.yiplatform.service;

import cn.yiplatform.entity.VaccinationRecord;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【vaccination_record(疫苗接种记录)】的数据库操作Service
* @createDate 2022-03-27 13:42:28
*/
public interface VaccinationRecordService extends IService<VaccinationRecord> {

    /**
     * 根据id查询疫苗接种记录，idList为空时查询所有记录
     * @param idList
     * @param beginDate
     * @param endDate
     * @param account
     * @return
     */
    Page<VaccinationRecord> getVaccinationRecord(Page<VaccinationRecord> page, List<Long> idList, Date beginDate, Date endDate, String account);

    /**
     * 根据用户id  更新用户修改的疫苗接种记录
     * @param id
     * @param wrapper
     * @return
     */
    Boolean updateVaccinationRecord(Long id, Map<String, Object> wrapper);

    /**
     * 根据用户账号模糊查询疫苗接种记录
     * @param page
     * @param account
     * @return
     */
    Page<VaccinationRecord> searchVaccinationRecordByAccount(Page<VaccinationRecord> page, String account);

    /**
     * 新增疫苗接种记录
     * @param vaccinationRecord
     * @return
     */
    Boolean addVaccinationRecord(VaccinationRecord vaccinationRecord);

}
