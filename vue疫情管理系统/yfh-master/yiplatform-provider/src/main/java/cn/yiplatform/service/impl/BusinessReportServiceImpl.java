package cn.yiplatform.service.impl;

import cn.yiplatform.entity.BusinessReport;
import cn.yiplatform.mapper.BusinessReportMapper;
import cn.yiplatform.service.BusinessReportService;
import cn.yiplatform.utils.CommonUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @date 2022/3/9-10:26
 */
@Repository
@DubboService(interfaceClass = BusinessReportService.class, version = "1.0", timeout = 1800000000)
@EnableTransactionManagement
public class BusinessReportServiceImpl extends ServiceImpl<BusinessReportMapper, BusinessReport>
        implements BusinessReportService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BusinessReportMapper businessReportMapper;

    @Override
    public Page<BusinessReport> getBusinessReport(Page<BusinessReport> page, List<Long> idList, Date beginDate, Date endDate, String account, Integer status) {
        Page<BusinessReport> businessReports;
        try {
            businessReports = businessReportMapper.selectAllByWrappers(page, idList, beginDate, endDate, "%" + account + "%", status);
        } catch (Exception e) {
            businessReports = new Page<>();
            logger.error("方法 getBusinessReportByIds 异常", e);
        }
        return businessReports;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateBusinessReport(Long id, Map<String, Object> wrapper) {
        Boolean result;
        BusinessReport businessReport = new BusinessReport();
        // 报告id为空，返回false
        if (Objects.isNull(id)) {
            return false;
        }
        UpdateWrapper<BusinessReport> updateWrapper = new UpdateWrapper<>();
        int updateResult;
        try {
            // 指定条件
            businessReport.setUid(id);
            // 将修改的信息取出来作为条件构造器的更新内容
            for (String key : wrapper.keySet()) {
                updateWrapper.set(key, wrapper.get(key));
            }
            updateWrapper.eq("id", id);
            // 开始更新，结果不为0, 则说明更新成功
            updateResult = businessReportMapper.update(null, updateWrapper);

            if (updateResult > 0) {
                BusinessReport report = businessReportMapper.selectByReportId(id);
                String[] nullPropertyNames = CommonUtil.getNullPropertyNames(report);
                if (nullPropertyNames.length == 0) {
                    UpdateWrapper<BusinessReport> wrap = new UpdateWrapper<>();
                    wrap.eq("id", id).set("status", 1);
                    updateResult = businessReportMapper.update(null, wrap);
                }
            }
            result = updateResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新出差报告 updateBusinessReport 异常", e);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean alterBusinessReport(Long id, int statusCode) {
        int result;
        Boolean updateResult;
        UpdateWrapper<BusinessReport> updateWrapper = new UpdateWrapper<>();
        try {
            if (Objects.isNull(id)){
                return Boolean.FALSE;
            }
            updateWrapper.eq("id", id).set("status", statusCode);
            result = businessReportMapper.update(null, updateWrapper);
            updateResult = result > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            updateResult = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改状态 alterBusinessReport 异常", e);
        }
        return updateResult;
    }

    @Override
    public Page<BusinessReport> searchBusinessReportByAccount(Page<BusinessReport> page, String account) {
        Page<BusinessReport> businessReportPage;
        // 左右模糊查询
        account = "%" + account + "%";
        try {
            businessReportPage = businessReportMapper.selectAllLikeAccount(page, account);
        } catch (Exception e) {
            businessReportPage = new Page<>();
            logger.error("模糊查询出差记录 searchBusinessReportByAccount 异常", e);
        }
        return businessReportPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addBusinessReport(BusinessReport businessReport) {
        Boolean result;
        int insertResult;
        try {
            insertResult = businessReportMapper.insert(businessReport);
            result = insertResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("新增出差记录 addBusinessReport 异常", e);
        }
        return result;
    }
}
