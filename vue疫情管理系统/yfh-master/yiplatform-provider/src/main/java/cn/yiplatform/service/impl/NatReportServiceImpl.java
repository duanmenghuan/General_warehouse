package cn.yiplatform.service.impl;

import cn.yiplatform.entity.NatReport;
import cn.yiplatform.mapper.NatReportMapper;
import cn.yiplatform.service.NatReportService;
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
* @description 针对表【nat_report(核酸检测报告)】的数据库操作Service实现
* @createDate 2022-03-27 13:42:28
*/
@Service
@DubboService(interfaceClass = NatReportService.class, version = "1.0", timeout = 1800000000)
@EnableTransactionManagement
public class NatReportServiceImpl extends ServiceImpl<NatReportMapper, NatReport>
    implements NatReportService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private NatReportMapper natReportMapper ;

    @Override
    public Page<NatReport> getNatReport(Page<NatReport> page, List<Long> idList, Date beginDate, Date endDate, String account) {
        Page<NatReport> natReports = new Page<>();
        try {
//            if (CollectionUtils.isEmpty(idList)){
//                natReports = natReportMapper.selectAll(page);
//            } else if (Objects.isNull(beginDate)
//                    || Objects.isNull(endDate)){
//                natReports = natReportMapper.selectAllByIds(page, idList);
//            } else {
//                natReports = natReportMapper.selectAllByIdsAndCreateTimeBetween(page, idList, beginDate, endDate);
//            }
            natReports = natReportMapper.selectAllByWrappers(page, idList, beginDate, endDate, "%" + account + "%");
        }catch (Exception e) {
            natReports = new Page<>();
            logger.error("方法 getNatReport 异常", e);
        }
        return natReports;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateNatReport(Long id, Map<String, Object> wrapper) {
        Boolean result;
        NatReport natReport = new NatReport();
        // 用户id为空，返回false
        if (Objects.isNull(id)) {
            return false;
        }
        UpdateWrapper<NatReport> updateWrapper = new UpdateWrapper<>();
        int updateResult;
        natReport.setId(id);
        try {
            // 将修改的信息取出来作为条件构造器的更新内容
            for (String key : wrapper.keySet()) {
                updateWrapper.set(key, wrapper.get(key));
            }
            // 指定条件
            updateWrapper.eq("id", id);
            // 开始更新，结果不为0, 则说明更新成功
            updateResult = natReportMapper.update(null, updateWrapper);
            result = updateResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新核酸检测记录 updateNatReport 异常", e);
        }
        return result;
    }

    @Override
    public Page<NatReport> searchNatReportByAccount(Page<NatReport> page, String account) {
        Page<NatReport> natReportPage;
        // 左右模糊查询
        account = "%" + account + "%";
        try {
            natReportPage = natReportMapper.selectAllLikeAccount(page, account);
        } catch (Exception e) {
            natReportPage = new Page<>();
            logger.error("模糊查询核酸检测记录 searchNatReportByAccount 异常", e);
        }
        return natReportPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addNatReport(NatReport natReport) {
        Boolean result;
        int insertResult;
        try {
            insertResult = natReportMapper.insert(natReport);
            result = insertResult > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            result = Boolean.FALSE;
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("新增核酸检测记录 addNatReport 异常", e);
        }
        return result;
    }

}




