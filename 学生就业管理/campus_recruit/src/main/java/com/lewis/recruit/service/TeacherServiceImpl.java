package com.lewis.recruit.service;

import com.lewis.recruit.mappers.TeacherMapper;
import com.lewis.recruit.pojo.Company;
import com.lewis.recruit.pojo.Teacher;
import com.lewis.recruit.utils.SaltUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findTeacherByTeacherAccount(String teacherAccount) {
        return teacherMapper.getTeacherByTeaAccount(teacherAccount);
    }

    @Override
    public int saveTeacher(Teacher teacher) {
        //随机生成盐
        String salt = SaltUtils.getSalt(4);
        //将盐存入数据
        teacher.setTeacherSalt(salt);
        //将明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(teacher.getTeacherPassword(), salt, 1024);
        //更换加密后的密码
        teacher.setTeacherPassword(md5Hash.toHex());
        return teacherMapper.saveTeacher(teacher);
    }

    @Override
    public int updateTeacherPwd(Teacher teacher, String newPassword) {
        //讲新密码赋值给学生对象
        teacher.setTeacherPassword(newPassword);
        //重新生成盐
        String salt = SaltUtils.getSalt(4);
        //将盐存入数据
        teacher.setTeacherSalt(salt);
        //将明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(teacher.getTeacherPassword(), salt, 1024);
        //更换加密后的密码
        teacher.setTeacherPassword(md5Hash.toHex());
        return teacherMapper.updateTeaPwdByTeaId(teacher);
    }

    //查询所有学生用户信息
    @Override
    public List<Teacher> getTeacherList() {
        return teacherMapper.getTeacherList();
    }

    //验证学生输入的旧密码是否正确
    @Override
    public Boolean verifyOldPwd(String oldPassword) {
        //利用shiro框架获取当前登录的用户
        Teacher teacher = (Teacher)SecurityUtils.getSubject().getPrincipal();
        String salt = teacher.getTeacherSalt();
        String teacherPassword = teacher.getTeacherPassword();
        Md5Hash md5Hash = new Md5Hash(oldPassword,salt,1024);
        return teacherPassword.equals(md5Hash.toHex());
    }

    @Override
    public int deleteTeacherById(Integer teacherId) {
        return teacherMapper.deleteTeacherById(teacherId);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    //验证用户输入的旧密码是否正确
    @Override
    public Boolean verifyComPwd(String oldPassword) {
        //获取当前用户
        Teacher teacher = (Teacher) SecurityUtils.getSubject().getPrincipal();
        String salt = teacher.getTeacherSalt();
        Md5Hash md5Hash = new Md5Hash(oldPassword,salt,1024);
        return teacher.getTeacherPassword().equals(md5Hash.toHex());
    }
}
