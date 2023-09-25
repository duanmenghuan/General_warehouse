package com.sjsq.dao.impl;

import com.sjsq.dao.StudentDao;
import com.sjsq.utils.DBUtil;
import com.sjsq.vo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDaoImpl implements StudentDao {

    // 按某个栏位查询所有学生信息
    public List<Student> selectAll(String sql, Object[] arr) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1.连接数据库
            con = DBUtil.getConnection();
            // 2.预编译
            ps = con.prepareStatement(sql);
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    // 传入sql的参数,向上转型,某个栏位的查询
                    ps.setObject(i + 1, arr[i]);
                }
            }
            // 3.执行sql
            rs = ps.executeQuery();
            // 4.保存查询出来的数据到list
            List<Student> studentList = new ArrayList<>();
            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setNation(rs.getString("nation"));
                student.setPlace(rs.getString("place"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getNString("classes"));
                student.setgrade(rs.getString("grade"));

                studentList.add(student);
            }
            return studentList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭链接，避免数据库连接过多
            DBUtil.close(con, ps, rs);
        }
        return null;
    }


    /**
     * 根据学号查询学生信息
     * @param id
     * @return
     */
    public Student selectStudent(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.连接数据库
            con = DBUtil.getConnection();
            // 2.预编译
            String sql = "select * from student where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            // 3.执行sql
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setNation(rs.getString("nation"));
                student.setPlace(rs.getString("place"));
                student.setMajor(rs.getString("major"));
                student.setClasses(rs.getNString("classes"));
                student.setgrade(rs.getString("grade"));
                return student;
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

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    public boolean addStudent(Student student) {
        String sql = "insert into student values (?,?,?,?,?,?,?,?,?)";
        List<Object> list = new ArrayList<Object>();

        list.add(student.getId());
        list.add(student.getName());
        list.add(student.getAge());
        list.add(student.getSex());
        list.add(student.getNation());
        list.add(student.getPlace());
        list.add(student.getMajor());
        list.add(student.getClasses());
        list.add(student.getgrade());

        boolean flag = DBUtil.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @Override
    public boolean updateStudent(Student student) {
        String sql = "update student set name=?,age=?,sex=?,nation=?,place=?,major=?,classes=?,grade=? where id=?";

        List<Object> list = new ArrayList<Object>();


        list.add(student.getName());
        list.add(student.getAge());
        list.add(student.getSex());
        list.add(student.getNation());
        list.add(student.getPlace());
        list.add(student.getMajor());
        list.add(student.getClasses());
        list.add(student.getId());
        list.add(student.getgrade());

        boolean flag = DBUtil.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteStudent(Integer id) {
        String sql = "delete from student where id=?";
        List<Object> list = new ArrayList<Object>();

        list.add(id);

        boolean flag = DBUtil.addUpdateDelete(sql,list.toArray());
        if(flag){
            return true;
        }else {
            return false;
        }
    }
}
