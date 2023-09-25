package cn.com.xyecy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.com.xyecy.bean.Bar;

public class BarDao {

    /**
     * @author wen
     *
     * 查询所有数据
     * @return 存放所有数据的线性表
     */
    public ArrayList<Bar> query() {
        ArrayList<Bar> barArr = new ArrayList<Bar>();
        try {
            //JDBC方式连接MySQL数据库
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/job51?characterEncoding=utf8", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bar");
            ResultSet rs = stmt.executeQuery();
            //将test表中的数据存储到线性表中
            while(rs.next()) {
                Bar bar = new Bar();
                bar.setName(rs.getString("name"));
                bar.setNum(rs.getInt("num"));
                barArr.add(bar);
            }
            //关闭连接
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return barArr;
    }
}
