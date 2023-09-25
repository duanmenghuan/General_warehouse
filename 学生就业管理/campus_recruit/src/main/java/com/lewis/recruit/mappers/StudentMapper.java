package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    //根据学生账号查询学生信息
    Student getStudentByStuAccount(String studentAccount);
    //添加学生账号
    int saveStudent(Student student);
    //修改学生密码
    int updateStuPwdByStuId(Student student);

    //查询所有学生用户信息
    List<Student> getStudentList();

    //删除学生用户
    int deleteStudentByStuId(Integer studentId);

    //修改资料
    int updateStudent(Student student);

    List<Student> getStudentByPositionId(Integer positionId);

    @Select("select * from student where student_classg = #{teacherNo}")
    List<Student> getStudentListByClassG(String teacherNo);

    @Select("select * from student where student_id = #{studentId}")
    Student findStudentById(Integer studentId);
}
