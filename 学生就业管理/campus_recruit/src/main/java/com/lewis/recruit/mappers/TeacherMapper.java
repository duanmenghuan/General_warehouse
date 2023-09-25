package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Student;
import com.lewis.recruit.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    Teacher getTeacherByTeaAccount(String teacherAccount);
    int saveTeacher(Teacher teacher);
    int updateTeaPwdByTeaId(Teacher teacher);

    List<Teacher> getTeacherList();

    int deleteTeacherById(Integer teacherId);

    int updateTeacher(Teacher teacher);
}
