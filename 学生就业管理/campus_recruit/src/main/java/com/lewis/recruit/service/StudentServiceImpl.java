package com.lewis.recruit.service;

import com.lewis.recruit.mappers.StudentMapper;
import com.lewis.recruit.pojo.Student;
import com.lewis.recruit.utils.SaltUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    //通过账号查询学生信息
    @Override
    public Student findStudentByStudentAccount(String studentAccount) {
        return studentMapper.getStudentByStuAccount(studentAccount);
    }

    //学生注册功能，添加学生用户
    @Override
    public int saveStudent(Student student) {
        //随机生成盐
        String salt = SaltUtils.getSalt(4);
        //将盐存入数据
        student.setStudentSalt(salt);
        //将明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(student.getStudentPassword(), salt, 1024);
        //更换加密后的密码
        student.setStudentPassword(md5Hash.toHex());
        return studentMapper.saveStudent(student);
    }

    //修改学生的密码
    @Override
    public int updateStudentPwd(Student student, String newPassword) {
        //讲新密码赋值给学生对象
        student.setStudentPassword(newPassword);
        //重新生成盐
        String salt = SaltUtils.getSalt(4);
        //将盐存入数据
        student.setStudentSalt(salt);
        //将明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(student.getStudentPassword(), salt, 1024);
        //更换加密后的密码
        student.setStudentPassword(md5Hash.toHex());
        return studentMapper.updateStuPwdByStuId(student);
    }

    //查询所有学生用户信息
    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }

    //验证学生输入的旧密码是否正确
    @Override
    public Boolean verifyOldPwd(String oldPassword) {
        //利用shiro框架获取当前登录的用户
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        String salt = student.getStudentSalt();
        String studentPassword = student.getStudentPassword();
        Md5Hash md5Hash = new Md5Hash(oldPassword,salt,1024);
        return studentPassword.equals(md5Hash.toHex());
    }

    @Override
    public int deleteStudentByStuId(Integer studentId) {
        return studentMapper.deleteStudentByStuId(studentId);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> getStudentByPositionId(Integer positionId) {
        return studentMapper.getStudentByPositionId(positionId);
    }

    @Override
    public List<Student> getStudentListByClassG(String teacherNo) {
        return studentMapper.getStudentListByClassG(teacherNo);
    }

    public Student findStudentById(Integer studentId) {
        return studentMapper.findStudentById(studentId);
    }
}
