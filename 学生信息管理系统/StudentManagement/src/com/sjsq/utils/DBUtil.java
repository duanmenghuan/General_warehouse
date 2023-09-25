package com.sjsq.utils;

import java.sql.*;


public class DBUtil {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/jsp_student_management?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root";

    /**
     * 连接数据库的方法
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }

    /**
     * 关闭数据库的方法
     * @param con
     * @param ps
     * @param rs
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        // 关闭资源，避免出现异常
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
     * 设置增删改的方法
     * @param sql
     * @param arr
     * @return
     */
    public static boolean addUpdateDelete(String sql,Object[] arr){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 第一步：连接数据库
            con = DBUtil.getConnection();
            // 第二步：预编译
            ps = con.prepareStatement(sql);
            // 第三步：设置值
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

    // 测试
    public static void main(String[] args){
        try {
            DBUtil.getConnection();
            System.out.println("---测试数据库链接成功---");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
