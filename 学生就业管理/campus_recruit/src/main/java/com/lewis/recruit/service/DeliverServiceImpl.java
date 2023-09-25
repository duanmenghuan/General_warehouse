package com.lewis.recruit.service;

import com.lewis.recruit.mappers.DeliverMapper;
import com.lewis.recruit.pojo.Deliver;
import com.lewis.recruit.pojo.Student;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliverServiceImpl implements DeliverService{
    @Autowired
    private DeliverMapper deliverMapper;
    @Override
    public int addDeliver(Deliver deliver) {
        return deliverMapper.addDeliver(deliver);
    }

    //根据职位id和简历id修改投递状态
    @Override
    public int updateDeliverStateByPositionAndStudent(Integer positionId, Integer studentId,String result) {
        return deliverMapper.updateDeliverStateByPositionAndStudent(positionId,studentId,result);
    }


    //通过投递信息id删除投递记录
    @Override
    public int deleteDeliverByDeliverId(Integer deliverId) {
        return deliverMapper.deleteDeliverByDeliverId(deliverId);
    }

    //通过简历id和职位id查询简历信息
    @Override
    public Deliver getDeliverByStudentAndPosition(Integer studentId, Integer positionId) {
        return deliverMapper.getDeliverByStudentAndPosition(studentId, positionId);
    }

    //通过用户id查询所有投递记录
    @Override
    public List<Deliver> getDeliverByResumeId() {
        //利用shiro框架获取当前登录的用户
        Student student = (Student) SecurityUtils.getSubject().getPrincipal();
        //根据当前学生用户的id获取投递
        return deliverMapper.getDeliverByStudentId(student.getStudentId());
    }

    //通过公司用户id查询该公司所有投递信息
    @Override
    public List<Deliver> getDeliverByCompanyId(Integer companyId) {
        return deliverMapper.getDeliverByCompanyId(companyId);
    }

    //根据职位id查询职位被投递简历次数
    @Override
    public int deliverResumeCount(Integer positionId) {
        return deliverMapper.deliverResumeCount(positionId);
    }

    public Deliver getDeliverById(Integer deliverId) {
        return deliverMapper.getDeliverById(deliverId);
    }
}
