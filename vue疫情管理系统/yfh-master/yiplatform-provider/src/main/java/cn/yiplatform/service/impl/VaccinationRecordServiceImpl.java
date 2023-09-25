package cn.yiplatform.service.impl;

import cn.yiplatform.entity.VaccinationRecord;
import cn.yiplatform.mapper.VaccinationRecordMapper;
import cn.yiplatform.service.VaccinationRecordService;
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
* @description 针对表【vaccination_record(疫苗接种记录)】的数据库操作Service实现
* @createDate 2022-03-27 13:42:28
*/
@Service
@DubboService(interfaceClass = VaccinationRecordService.class, version = "1.0", timeout = 1800000000)
@EnableTransactionManagement
public class VaccinationRecordServiceImpl extends ServiceImpl<VaccinationRecordMapper, VaccinationRecord>
    implements VaccinationRecordService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private VaccinationRecordMapper vaccinationRecordMapper;

    @Override
    public Page<VaccinationRecord> getVaccinationRecord(Page<VaccinationRecord> page, List<Long> idList, Date beginDate, Date endDate, String account) {
        Page<VaccinationRecord> vaccinationRecords = new Page<>();
        try {
//            if (CollectionUtils.isEmpty(idList)){
//                vaccinationRecords = vaccinationRecordMapper.selectAll(page);
//            } else if (Objects.isNull(beginDate)
//                    || Objects.isNull(endDate)){
//                vaccinationRecords = vaccinationRecordMapper.selectAllByIds(page, idList);
//            } else {
//                vaccinationRecords = vaccinationRecordMapper.selectAllByAccountAndCreateTimeBetween(page, idList, beginDate, endDate);
//            }
            vaccinationRecords = vaccinationRecordMapper.selectAllByWrappers(page, idList, beginDate, endDate, "%" + account + "%");
        }catch (Exception e) {
            vaccinationRecords = new Page<>();
            logger.error("方法 getVaccinationRecordByIds异常", e);
        }
        return vaccinationRecords;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateVaccinationRecord(Long id, Map<String, Object> wrapper) {
        Boolean result;
        VaccinationRecord vaccinationRecord = new VaccinationRecord();
        // 用户id为空，返回false
        if (Objects.isNull(id)) {
            return false;
        }
        UpdateWrapper<VaccinationRecord> updateWrapper = new UpdateWrapper<>();
        int updateResult;
        vaccinationRecord.setId(id);
        try {
            // 将修改的信息取出来作为条件构造器的更新内容
            for (String key : wrapper.keySet()) {
                updateWrapper.set(key, wrapper.get(key));
            }
            // 指定条件
            updateWrapper.eq("id", id);
            // 开始更新，结果不为0, 则说明更新成功
            updateResult = vaccinationRecordMapper.update(null, updateWrapper);
            result = updateResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新核酸检测记录 updateVaccinationRecord 异常", e);
        }
        return result;
    }

    @Override
    public Page<VaccinationRecord> searchVaccinationRecordByAccount(Page<VaccinationRecord> page, String account) {
        Page<VaccinationRecord> vaccinationRecordPage;
        // 左右模糊查询
        account = "%" + account + "%";
        try {
            vaccinationRecordPage = vaccinationRecordMapper.selectAllLikeAccount(page, account);
        } catch (Exception e) {
            vaccinationRecordPage = new Page<>();
            logger.error("模糊查询核酸检测记录 searchVaccinationRecordByAccount 异常", e);
        }
        return vaccinationRecordPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addVaccinationRecord(VaccinationRecord vaccinationRecord) {
        Boolean result;
        int insertResult;
        try {
            insertResult = vaccinationRecordMapper.insert(vaccinationRecord);
            result = insertResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("新增核酸检测记录 addVaccinationRecord 异常", e);
        }
        return result;
    }
}




