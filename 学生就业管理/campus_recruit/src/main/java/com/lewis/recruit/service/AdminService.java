package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Admin;

public interface AdminService {
    //根据管理员账号查询管理员信息
    Admin findAdminByAdminAccount(String adminAccount);

    //修改管理员密码
    int updatePwd(Admin admin, String newPassword);

    int saveAdmin(Admin admin);
}
