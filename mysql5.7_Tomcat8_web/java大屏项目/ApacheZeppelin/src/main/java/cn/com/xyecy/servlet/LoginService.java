package cn.com.xyecy.servlet;


import cn.com.xyecy.bean.Bar;
import cn.com.xyecy.bean.User;
import cn.com.xyecy.dao.Dao;
import sun.awt.windows.WPrinterJob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Dao dao=new Dao();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if(username==null||password==null){
            //重新登录
            System.out.println("账号或密码错误！");
            response.sendRedirect("logon.html");
        }else{
            String sql="select * from user where username=? and password=?";
            try {
                Connection conn = dao.conn();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
//                    User user = new User();
//                    user.getUsername();
                    //登陆成功，跳转到success页面
                    System.out.println("登陆成功！！");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    conn.close();
                    /*response.sendRedirect("success.html");*/
                }else{
                    System.out.println("账号或密码错误！");
                    response.sendRedirect("logon.html");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
