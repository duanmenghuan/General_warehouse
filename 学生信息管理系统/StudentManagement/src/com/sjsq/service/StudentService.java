package com.sjsq.service;

import com.sjsq.vo.Student;

import java.util.List;


public interface StudentService {

    /**
     * ��ѯѧ����Ϣ
     * @param student
     * @return
     */
    public List<Student> selectAll(Student student);


    /**
     * ����ѧ�Ž��в�ѯ
     * @param id
     * @return
     */
    public Student selectStudent(Integer id);


    /**
     * ����ѧ����Ϣ
     * @param student
     * @return
     */
    public boolean addStudent(Student student);

    /**
     * �޸�ѧ����Ϣ
     * @param student
     * @return
     */
    public boolean updateStudent(Student student);

    /**
     * ɾ��ѧ����Ϣ
     * @param id
     * @return
     */
    public boolean deleteStudent(Integer id);
}
