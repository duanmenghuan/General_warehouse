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
     * �û���¼
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.��ȡ���ݿ�����
            con = DBUtil.getConnection();
            // 2.дsql
            String sql = "select * from admin where username = ? and password = ?";
            // 3.Ԥ����
            ps = con.prepareStatement(sql);
            // 4.����ֵ
            ps.setObject(1,admin.getUsername());
            ps.setObject(2,admin.getPassword());
            rs = ps.executeQuery();
            Admin adminLogin = null;
            if(rs.next()){
                adminLogin = new Admin();
                // �����ݿ��л�ȡֵ��ʵ�����setter������
                adminLogin.setUsername(rs.getString("username"));
                adminLogin.setPassword(rs.getString("password"));

                // ���ص������ѯ�����������Ķ���
                return adminLogin;

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // �ر���Դ����������쳣
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
