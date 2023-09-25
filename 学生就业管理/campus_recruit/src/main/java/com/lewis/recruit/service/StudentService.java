package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Student;

import java.util.List;

public interface StudentService {
    //根据学生账号查询学生信息
    Student findStudentByStudentAccount(String studentAccount);

    //添加学生账号
    int saveStudent(Student student);

    //修改学生密码
    int updateStudentPwd(Student student, String newPassword);

    //查询所有学生用户信息
    List<Student> getStudentList();

    //验证学生旧密码是否正确
    Boolean verifyOldPwd(String oldPassword);

    //删除学生用户
    int deleteStudentByStuId(Integer studentId);

    int updateStudent(Student student);

    List<Student> getStudentByPositionId(Integer positionId);

    List<Student> getStudentListByClassG(String teacherNo);
}
