package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findTeacherByTeacherAccount(String teacherAccount);

    int saveTeacher(Teacher teacher);

    int updateTeacherPwd(Teacher teacher, String newPassword);

    List<Teacher> getTeacherList();

    Boolean verifyOldPwd(String oldPassword);

    int deleteTeacherById(Integer teacherId);

    int updateTeacher(Teacher teacher);

    Boolean verifyComPwd(String oldPassword);
}
