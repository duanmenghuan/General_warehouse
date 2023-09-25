package com.lewis.recruit.service;

import com.lewis.recruit.pojo.Consultation;
import com.lewis.recruit.pojo.Deliver;

import java.util.List;

public interface ConsultationService {

    void addConsultation(Consultation consultation);

    List<Consultation> getConsultationByCompanyId(Integer companyId);

    Consultation getConsultationById(Integer consultationId);

    List<Consultation> getConsultationByParentId(Integer consultationId);

    List<Consultation> getConsultationByTeacherId(Integer teacherId);

    List<Consultation> getConsultationByStudentId(Integer studentId);
}
