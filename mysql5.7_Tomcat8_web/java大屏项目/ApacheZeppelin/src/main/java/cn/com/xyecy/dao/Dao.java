package cn.com.xyecy.dao;

import cn.com.xyecy.bean.Bar;

import java.sql.*;
import java.util.ArrayList;

public class Dao {

    public Connection conn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/job51?characterEncoding=utf8", "root", "root");
    }


}
