package com.sjsq.utils;

import java.sql.*;


public class DBUtil {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/jsp_student_management?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    /**
     * �������ݿ�ķ���
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // �������ݿ�����
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }

    /**
     * �ر����ݿ�ķ���
     * @param con
     * @param ps
     * @param rs
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        // �ر���Դ����������쳣
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ������ɾ�ĵķ���
     * @param sql
     * @param arr
     * @return
     */
    public static boolean addUpdateDelete(String sql,Object[] arr){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // ��һ�����������ݿ�
            con = DBUtil.getConnection();
            // �ڶ�����Ԥ����
            ps = con.prepareStatement(sql);
            // ������������ֵ
            if(arr != null && arr.length !=0){
                for (int i = 0; i < arr.length; i++) {
                    ps.setObject(i+1,arr[i]);
                }
            }
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ����
    public static void main(String[] args){
        try {
            DBUtil.getConnection();
            System.out.println("---�������ݿ����ӳɹ�---");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
