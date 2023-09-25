package cn.yiplatform.mapper;

import cn.yiplatform.entity.BusinessReport;
import cn.yiplatform.entity.TeleWorkRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
*
* @description 针对表【tele_work_record(远程办公记录)】的数据库操作Mapper
* @createDate 2022-03-27 17:39:32
* @Entity cn.yiplatform.entity.TeleWorkRecord
*/
public interface TeleWorkRecordMapper extends BaseMapper<TeleWorkRecord> {
    // 根据用户id查询远程办公记录
    Page<TeleWorkRecord> selectAllByIds(Page<TeleWorkRecord> page, List<Long> idList);

    // 查询所有的远程办公记录
    Page<TeleWorkRecord> selectAll(Page<TeleWorkRecord> page);

    // 根据用户账号模糊查询远程办公记录
    Page<TeleWorkRecord> selectAllLikeAccount(Page<TeleWorkRecord> page, String account);

    // 根据创建日期区间查询远程办公记录
    Page<TeleWorkRecord> selectAllByIdsAndCreateTimeBetween(Page<TeleWorkRecord> page, List<Long> idList, @Param("beginCreateTime") Date beginCreateTime, @Param("endCreateTime") Date endCreateTime);

    // 多条件组合查询远程办公记录
    Page<TeleWorkRecord> selectAllByWrappers(Page<TeleWorkRecord> page, List<Long> idList, @Param("beginSubmitTime") Date beginSubmitTime, @Param("endSubmitTime") Date endSubmitTime, String account, Integer status);

    // 根据记录id查询远程办公记录
    TeleWorkRecord selectByRecordId(Long recordId);
}




