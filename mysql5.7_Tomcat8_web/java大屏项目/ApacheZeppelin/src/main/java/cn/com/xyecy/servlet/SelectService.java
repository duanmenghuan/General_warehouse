package cn.com.xyecy.servlet;


import cn.com.xyecy.dao.Dao;

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

@WebServlet("/select_v_name")
public class SelectService extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("v_name");
        System.out.println(name);
        if(name!=null){
            //request.getRequestDispatcher("success.html").forward(request, response);
            response.sendRedirect("success.html");

        }


        //request.getRequestDispatcher("success").forward(request, response);

    }

}
