package com.sjsq.service;

import com.sjsq.vo.Admin;
import com.sjsq.vo.Student;

public interface AdminService {

    /**
     * �û���¼
     * @param admin
     * @return
     */
    public Admin login(Admin Admin);

    public boolean addAdmin(Admin Admin);
}
