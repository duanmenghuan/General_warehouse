package cn.yiplatform.service;

import cn.yiplatform.entity.TeleWorkRecord;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【tele_work_record(远程办公记录)】的数据库操作Service
* @createDate 2022-03-27 17:39:32
*/
public interface TeleWorkRecordService extends IService<TeleWorkRecord> {
    
    /**
     * 根据id查询远程办公记录，idList为空时查询所有记录
     * @param idList
     * @param beginDate
     * @param endDate
     * @param account
     * @param status
     * @return
     */
    Page<TeleWorkRecord> getTeleWorkRecord(Page<TeleWorkRecord> page, List<Long> idList, Date beginDate, Date endDate, String account, Integer status);

    /**
     * 根据用户id  更新用户修改的远程办公记录
     * @param id
     * @param wrapper
     * @return
     */
    Boolean updateTeleWorkRecord(Long id, Map<String, Object> wrapper);

    /**
     * 根据用户账号模糊查询远程办公记录
     * @param page
     * @param account
     * @return
     */
    Page<TeleWorkRecord> searchTeleWorkRecordByAccount(Page<TeleWorkRecord> page, String account);

    /**
     * 新增远程办公记录
     * @param teleWorkRecord
     * @return
     */
    Boolean addTeleWorkRecord(TeleWorkRecord teleWorkRecord);

    /**
     * 根据远程办公记录id修改远程办公记录状态
     * @param id
     * @return
     */
    Boolean alterTeleWorkStatus(Long id, int statusCode);
}
