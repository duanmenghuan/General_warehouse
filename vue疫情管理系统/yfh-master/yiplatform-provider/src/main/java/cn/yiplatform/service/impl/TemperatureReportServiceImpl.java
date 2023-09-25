package cn.yiplatform.service.impl;

import cn.yiplatform.entity.TemperatureReport;
import cn.yiplatform.mapper.TemperatureReportMapper;
import cn.yiplatform.service.TemperatureReportService;
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
 * @date 2022/3/10-17:29
 */
@Service
@DubboService(interfaceClass = TemperatureReportService.class, version = "1.0", timeout = 1800000000)
@EnableTransactionManagement
public class TemperatureReportServiceImpl extends ServiceImpl<TemperatureReportMapper, TemperatureReport>
        implements TemperatureReportService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TemperatureReportMapper temperatureReportMapper;

    @Override
    public Page<TemperatureReport> getTempReport(Page<TemperatureReport> page,
                                                 List<Long> idList,
                                                 Date beginDate,
                                                 Date endDate,
                                                 String account) {
        Page<TemperatureReport> healthyReports = new Page<>();
        try {
//            if (CollectionUtils.isEmpty(idList)){
//                healthyReports = temperatureReportMapper.selectAll(page);
//            } else if (Objects.isNull(beginDate)
//                    || Objects.isNull(endDate)){
//                healthyReports = temperatureReportMapper.selectAllByIds(page, idList);
//            } else {
//                healthyReports = temperatureReportMapper.selectAllByAccountAndSubmitTimeBetween(page, idList, beginDate, endDate);
//            }
            healthyReports = temperatureReportMapper.selectAllByWrappers(page, idList, beginDate, endDate, "%" + account + "%");
        }catch (Exception e) {
            healthyReports = new Page<>();
            logger.error("方法getTempReport 异常", e);
        }
        return healthyReports;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTempReport(Long id, Map<String, Object> wrapper) {
        Boolean result;
        TemperatureReport temperatureReport = new TemperatureReport();
        // 用户id为空，返回false
        if (Objects.isNull(id)) {
            return false;
        }
        UpdateWrapper<TemperatureReport> updateWrapper = new UpdateWrapper<>();
        int updateResult;
        temperatureReport.setId(id);
        try {
            // 将修改的信息取出来作为条件构造器的更新内容
            for (String key : wrapper.keySet()) {
                updateWrapper.set(key, wrapper.get(key));
            }
            // 指定条件
            updateWrapper.eq("id", id);
            // 开始更新，结果不为0, 则说明更新成功
            updateResult = temperatureReportMapper.update(null, updateWrapper);
            result = updateResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新健康报告 updateTempReport 异常", e);
        }
        return result;
    }

    @Override
    public Page<TemperatureReport> searchTempReportByAccount(Page<TemperatureReport> page, String account) {
        Page<TemperatureReport> healthyReportPage;
        // 左右模糊查询
        account = "%" + account + "%";
        try {
            healthyReportPage = temperatureReportMapper.selectAllLikeAccount(page, account);
        } catch (Exception e) {
            healthyReportPage = new Page<>();
            logger.error("模糊查询健康记录 searchTempReportByAccount 异常", e);
        }
        return healthyReportPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addTempReport(TemperatureReport temperatureReport) {
        Boolean result;
        int insertResult;
        try {
            insertResult = temperatureReportMapper.insert(temperatureReport);
            result = insertResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("新增健康记录 addBusinessReport 异常", e);
        }
        return result;
    }

    @Override
    public Page<TemperatureReport> getTodayFillStatusEmployee(Page<TemperatureReport> page, Integer fillStatus) {
        Page<TemperatureReport> temperatureReportPage = new Page<>();
        try {
            temperatureReportPage = temperatureReportMapper.selectAllByFillStatus(page, fillStatus);
        } catch (Exception e) {
            logger.error("getTodayFillStatusEmployee 方法异常", e);
        }
        return temperatureReportPage;
    }

    @Override
    public Page<TemperatureReport> getAbnormalTempData(Page<TemperatureReport> page) {

        Page<TemperatureReport> abnormalTempData = new Page<>();
        try {
            abnormalTempData = temperatureReportMapper.selectAbnormalTempData(page);
        } catch (Exception e) {
            logger.error("getAbnormalTempData 方法异常", e);
        }
        return abnormalTempData;
    }
}
