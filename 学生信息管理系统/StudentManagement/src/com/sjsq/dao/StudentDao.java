package com.sjsq.dao;


import com.sjsq.vo.Student;
import java.util.List;



public interface StudentDao {


    /**
     * ��ѯѧ����Ϣ
     * @param sql
     * @param arr
     * @return
     */
    public List<Student> selectAll(String sql, Object[] arr);


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
