package com.sjsq.service;

import com.sjsq.vo.Student;

import java.util.List;


public interface StudentService {

    /**
     * 查询学生信息
     * @param student
     * @return
     */
    public List<Student> selectAll(Student student);


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
