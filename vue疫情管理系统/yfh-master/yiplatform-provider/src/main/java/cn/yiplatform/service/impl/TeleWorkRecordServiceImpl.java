package cn.yiplatform.service.impl;

import cn.yiplatform.entity.BusinessReport;
import cn.yiplatform.entity.TeleWorkRecord;
import cn.yiplatform.mapper.TeleWorkRecordMapper;
import cn.yiplatform.service.TeleWorkRecordService;
import cn.yiplatform.utils.CommonUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
*
* @description 针对表【tele_work_record(远程办公记录)】的数据库操作Service实现
* @createDate 2022-03-27 17:39:32
*/
@Service
@DubboService(interfaceClass = TeleWorkRecordService.class, version = "1.0", timeout = 1800000000)
@EnableTransactionManagement
public class TeleWorkRecordServiceImpl extends ServiceImpl<TeleWorkRecordMapper, TeleWorkRecord>
    implements TeleWorkRecordService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TeleWorkRecordMapper teleWorkRecordMapper ;

    @Override
    public Page<TeleWorkRecord> getTeleWorkRecord(Page<TeleWorkRecord> page, List<Long> idList, Date beginDate, Date endDate, String account, Integer status) {
        Page<TeleWorkRecord> teleWorkRecords = new Page<>();
        try {
//            if (CollectionUtils.isEmpty(idList)){
//                teleWorkRecords = teleWorkRecordMapper.selectAll(page);
//            } else if (Objects.isNull(beginDate)
//                    || Objects.isNull(endDate)){
//                teleWorkRecords = teleWorkRecordMapper.selectAllByIds(page, idList);
//            } else {
//                teleWorkRecords = teleWorkRecordMapper.selectAllByIdsAndCreateTimeBetween(page, idList, beginDate, endDate);
//            }
            teleWorkRecords = teleWorkRecordMapper.selectAllByWrappers(page, idList, beginDate, endDate, "%" + account + "%", status);
        }catch (Exception e) {
            teleWorkRecords = new Page<>();
            logger.error("方法 getTeleWorkRecordByIds异常", e);
        }
        return teleWorkRecords;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTeleWorkRecord(Long id, Map<String, Object> wrapper) {
        Boolean result;
        TeleWorkRecord teleWorkRecord = new TeleWorkRecord();
        // 用户id为空，返回false
        if (Objects.isNull(id)) {
            return false;
        }
        UpdateWrapper<TeleWorkRecord> updateWrapper = new UpdateWrapper<>();
        int updateResult;
        teleWorkRecord.setId(id);
        try {
            // 将修改的信息取出来作为条件构造器的更新内容
            for (String key : wrapper.keySet()) {
                updateWrapper.set(key, wrapper.get(key));
            }
            // 指定条件
            updateWrapper.eq("id", id);
            // 开始更新，结果不为0, 则说明更新成功
            updateResult = teleWorkRecordMapper.update(null, updateWrapper);
            if (updateResult > 0) {
                TeleWorkRecord record = teleWorkRecordMapper.selectByRecordId(id);
                String[] nullPropertyNames = CommonUtil.getNullPropertyNames(record);
                if (nullPropertyNames.length == 0) {
                    UpdateWrapper<TeleWorkRecord> wrap = new UpdateWrapper<>();
                    wrap.eq("id", id).set("status", 1);
                    updateResult = teleWorkRecordMapper.update(null, wrap);
                }
            }
            result = updateResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新远程办公记录 updateTeleWorkRecord 异常", e);
        }
        return result;
    }

    @Override
    public Page<TeleWorkRecord> searchTeleWorkRecordByAccount(Page<TeleWorkRecord> page, String account) {
        Page<TeleWorkRecord> teleWorkRecordPage;
        // 左右模糊查询
        account = "%" + account + "%";
        try {
            teleWorkRecordPage = teleWorkRecordMapper.selectAllLikeAccount(page, account);
        } catch (Exception e) {
            teleWorkRecordPage = new Page<>();
            logger.error("模糊查询远程办公记录 searchTeleWorkRecordByAccount 异常", e);
        }
        return teleWorkRecordPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addTeleWorkRecord(TeleWorkRecord teleWorkRecord) {
        Boolean result;
        int insertResult;
        try {
            insertResult = teleWorkRecordMapper.insert(teleWorkRecord);
            result = insertResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("新增远程办公记录 addTeleWorkRecord 异常", e);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean alterTeleWorkStatus(Long id, int statusCode) {
        int result;
        Boolean updateResult;
        UpdateWrapper<TeleWorkRecord> updateWrapper = new UpdateWrapper<>();
        try {
            if (Objects.isNull(id)){
                return Boolean.FALSE;
            }
            updateWrapper.eq("id", id).set("status", statusCode);
            result = teleWorkRecordMapper.update(null, updateWrapper);
            updateResult = result > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            updateResult = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改状态 alterTeleWorkStatus 异常", e);
        }
        return updateResult;
    }
}




