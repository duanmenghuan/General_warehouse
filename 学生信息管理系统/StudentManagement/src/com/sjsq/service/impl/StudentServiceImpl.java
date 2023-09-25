package com.sjsq.service.impl;

import com.sjsq.dao.StudentDao;
import com.sjsq.dao.impl.StudentDaoImpl;
import com.sjsq.service.StudentService;
import com.sjsq.vo.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();
    
    @Override
    public List<Student> selectAll(Student student) {
        StringBuffer sql = new StringBuffer("select * from student where 1 = 1 ");
        List<Object> list = new ArrayList<Object>();
        if(student != null){
            // 根据id来查找对应的学生信息
            if(student.getId() != null && student.getId() != 0){
                sql.append(" and id = ?");
                list.add(student.getId());
            }
        }
        return studentDao.selectAll(sql.toString(),list.toArray());
    }

    @Override
    public Student selectStudent(Integer id) {
        return studentDao.selectStudent(id);
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(Integer id) {
        return studentDao.deleteStudent(id);
    }
}
