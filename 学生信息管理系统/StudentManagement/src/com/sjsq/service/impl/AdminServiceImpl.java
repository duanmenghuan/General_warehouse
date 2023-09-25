package com.sjsq.service.impl;

import com.sjsq.dao.AdminDao;
import com.sjsq.dao.impl.AdminDaoImpl;
import com.sjsq.service.AdminService;
import com.sjsq.vo.Admin;


public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }


}
