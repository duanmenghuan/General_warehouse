package com.sjsq.dao;

import com.sjsq.vo.Admin;
import com.sjsq.vo.Student;


public interface AdminDao {

    /**
     * �û���¼
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

    public boolean addAdmin(Admin Admin);
}
