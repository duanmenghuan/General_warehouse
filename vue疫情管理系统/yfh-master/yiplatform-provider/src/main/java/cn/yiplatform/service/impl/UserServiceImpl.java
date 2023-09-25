package cn.yiplatform.service.impl;

import cn.yiplatform.entity.Menu;
import cn.yiplatform.entity.User;
import cn.yiplatform.mapper.UserMapper;
import cn.yiplatform.service.UserService;
import cn.yiplatform.utils.MD5Util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* @description 针对表【user(用户表，用来存储用户的基本信息)】的数据库操作Service实现
* @createDate 2022-03-04 23:00:35
*/
@Service
@DubboService(interfaceClass = UserService.class, version = "1.0", timeout = 1800000000)
@EnableTransactionManagement
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String, Object> authLogin(String account, String password) {
        Map<String, Object> authLoginResultMap = new HashMap<>();
        List<User> users;
        try {
            if (StringUtils.isEmpty(account) && StringUtils.isEmpty(password)) {
                return new HashMap<>();
            }
            users = userMapper.selectUserByAccountAndPassword(account, MD5Util.md5(password));
            if (CollectionUtils.isNotEmpty(users)
                    && users.size() == 1){
                users.get(0).setPassword(null);
                String s = JSON.toJSONString(users.get(0));
                authLoginResultMap.put("userInfo", JSONObject.parse(s));
            } else {
                return new HashMap<>();
            }
            List<Menu> menuList = userMapper.selectUserMenusByUid(users.get(0).getId());
            if (CollectionUtils.isNotEmpty(menuList)){
                authLoginResultMap.put("menus", menuList);
            } else {
                return new HashMap<>();
            }
        } catch (Exception e) {
            logger.error("方法authLogin 登录验证报错" ,e);
        }
        return authLoginResultMap;
    }

    @Override
    public String getPassword(String account) {
        List<User> users = userMapper.selectPasswordByAccount(account);
        String password = StringUtils.EMPTY;
        if (CollectionUtils.isNotEmpty(users)){
            password = users.get(0).getPassword();
        }
        return password;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updatePassword(String account, String newPassword) {
        Boolean result = false;
        try {
            // 更新密码
            int affectRows = userMapper.updatePasswordByAccount(newPassword, account);
            result = affectRows > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("updatePassword 更新密码失败", e);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateFillStatus(Long id) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        Boolean updateResult = Boolean.FALSE;
        try {
            wrapper.set("fill_status", 1).eq("id", id);
            int affectRows = userMapper.update(null, wrapper);
            updateResult = affectRows > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改填写状态失败", e);
        }
        return updateResult;
    }
}




