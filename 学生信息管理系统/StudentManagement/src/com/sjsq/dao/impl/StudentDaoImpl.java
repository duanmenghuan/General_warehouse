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

    // ��ĳ����λ��ѯ����ѧ����Ϣ
    public List<Student> selectAll(String sql, Object[] arr) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1.�������ݿ�
            con = DBUtil.getConnection();
            // 2.Ԥ����
            ps = con.prepareStatement(sql);
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    // ����sql�Ĳ���,����ת��,ĳ����λ�Ĳ�ѯ
                    ps.setObject(i + 1, arr[i]);
                }
            }
            // 3.ִ��sql
            rs = ps.executeQuery();
            // 4.�����ѯ���������ݵ�list
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
            // �ر����ӣ��������ݿ����ӹ���
            DBUtil.close(con, ps, rs);
        }
        return null;
    }


    /**
     * ����ѧ�Ų�ѯѧ����Ϣ
     * @param id
     * @return
     */
    public Student selectStudent(Integer id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.�������ݿ�
            con = DBUtil.getConnection();
            // 2.Ԥ����
            String sql = "select * from student where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            // 3.ִ��sql
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
            // �ر���Դ����������쳣
            DBUtil.close(con,ps,rs);
        }
        return null;
    }

    /**
     * ����ѧ����Ϣ
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
     * ����ѧ����Ϣ
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
     * ɾ��ѧ����Ϣ
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
