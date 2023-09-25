package com.sjsq.dao;


import com.sjsq.vo.Student;
import java.util.List;



public interface StudentDao {


    /**
     * 查询学生信息
     * @param sql
     * @param arr
     * @return
     */
    public List<Student> selectAll(String sql, Object[] arr);


    /**
     * 根据学号进行查询
     * @param id
     * @return
     */
    public Student selectStudent(Integer id);


    /**
     * 新增学生信息
     * @param student
     * @return
     */
    public boolean addStudent(Student student);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public boolean updateStudent(Student student);

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    public boolean deleteStudent(Integer id);
}
