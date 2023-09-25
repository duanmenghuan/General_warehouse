package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Deliver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeliverMapper {
    //增加投递信息
    int addDeliver(Deliver deliver);

    //根据职位id和简历id修改投递状态
    @Update("update deliver set deliver_state = #{result} where position_id = #{positionId} and student_id = #{studentId}")
    int updateDeliverStateByPositionAndStudent(@Param("positionId") Integer positionId, @Param("studentId") Integer studentId, @Param("result") String result);

    //删除投递信息
    int deleteDeliverByDeliverId(Integer deliverId);

    //根据简历id和职位id查询投递信息
    Deliver getDeliverByStudentAndPosition(Integer studentId, Integer positionId);

    //根据简历id查询投递信息
    List<Deliver> getDeliverByStudentId(Integer resumeId);

    //根据公司id查询投递信息
    List<Deliver> getDeliverByCompanyId(Integer companyId);

    //根据职位id查询职位被投递简历次数
    int deliverResumeCount(Integer positionId);

    @Select("select * from deliver where deliver_id = #{deliverId}")
    Deliver getDeliverById(Integer deliverId);
}
