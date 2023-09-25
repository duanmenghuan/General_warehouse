package com.lewis.recruit.mappers;

import com.lewis.recruit.pojo.Consultation;
import com.lewis.recruit.pojo.Deliver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConsultationMapper {

    void addConsultation(Consultation consultation);

    List<Consultation> getConsultationByCompanyId(Integer companyId);

    Consultation getConsultationById(Integer consultationId);

    List<Consultation> getConsultationByParentId(Integer consultationId);

    List<Consultation> getConsultationByTeacherId(Integer teacherId);

    List<Consultation> getConsultationByStudentId(Integer studentId);
}
