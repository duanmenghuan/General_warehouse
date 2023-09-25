package com.lewis.recruit.service;

import com.lewis.recruit.mappers.AdminMapper;
import com.lewis.recruit.pojo.Admin;
import com.lewis.recruit.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin findAdminByAdminAccount(String adminAccount) {
        return adminMapper.getAdminByAdminAccount(adminAccount);
    }

    //修改管理员密码
    @Override
    public int updatePwd(Admin admin, String newPassword) {
        String salt = SaltUtils.getSalt(4);
        admin.setAdminSalt(salt);
        Md5Hash md5Hash = new Md5Hash(newPassword, salt,1024);
        admin.setAdminPassword(md5Hash.toHex());
        return adminMapper.updatePwd(admin);
    }

    @Override
    public int saveAdmin(Admin admin) {
        //随机生成盐
        String salt = SaltUtils.getSalt(4);
        //将盐存入数据
        admin.setAdminSalt(salt);
        //将明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(admin.getAdminPassword(), salt, 1024);
        //更换加密后的密码
        admin.setAdminPassword(md5Hash.toHex());
        return adminMapper.saveAdmin(admin);
    }
}
