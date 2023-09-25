package com.sjsq.dao.impl;

import com.sjsq.dao.AdminDao;
import com.sjsq.utils.DBUtil;
import com.sjsq.vo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDaoImpl implements AdminDao {

    /**
     * 用户登录
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            con = DBUtil.getConnection();
            // 2.写sql
            String sql = "select * from admin where username = ? and password = ?";
            // 3.预编译
            ps = con.prepareStatement(sql);
            // 4.设置值
            ps.setObject(1,admin.getUsername());
            ps.setObject(2,admin.getPassword());
            rs = ps.executeQuery();
            Admin adminLogin = null;
            if(rs.next()){
                adminLogin = new Admin();
                // 从数据库中获取值到实体类的setter方法中
                adminLogin.setUsername(rs.getString("username"));
                adminLogin.setPassword(rs.getString("password"));

                // 返回的是你查询出来的完整的对象
                return adminLogin;

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            DBUtil.close(con,ps,rs);
        }
        return null;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        String sql = "insert into admin values (?,?)";
        List<Object> list = new ArrayList<Object>();

        list.add(admin.getUsername());
        list.add(admin.getPassword());


        boolean flag = DBUtil.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}
