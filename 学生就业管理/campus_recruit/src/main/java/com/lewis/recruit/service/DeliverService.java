package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Deliver;

import java.util.List;

public interface DeliverService {
    //增加投递信息
    int addDeliver(Deliver deliver);

    //根据职位id和简历id修改投递状态
    int updateDeliverStateByPositionAndStudent(Integer positionId, Integer studentId,String result);

    //删除投递信息
    int deleteDeliverByDeliverId(Integer deliverId);

    //根据简历id和职位id查询投递信息
    Deliver getDeliverByStudentAndPosition(Integer studentId, Integer positionId);

    //根据简历id查询投递信息
    List<Deliver> getDeliverByResumeId();

    //根据公司id查询投递信息
    List<Deliver> getDeliverByCompanyId(Integer companyId);

    //根据职位id查询职位被投递简历次数
    int deliverResumeCount(Integer positionId);
}
