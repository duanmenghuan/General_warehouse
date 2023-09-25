package com.lewis.recruit.service;

import com.lewis.recruit.mappers.ConsultationMapper;
import com.lewis.recruit.pojo.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService{
    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public void addConsultation(Consultation consultation) {
        consultationMapper.addConsultation(consultation);
    }

    @Override
    public List<Consultation> getConsultationByCompanyId(Integer companyId) {
        return consultationMapper.getConsultationByCompanyId(companyId);
    }

    @Override
    public Consultation getConsultationById(Integer consultationId) {
        return consultationMapper.getConsultationById(consultationId);
    }

    @Override
    public List<Consultation> getConsultationByParentId(Integer consultationId) {
        return consultationMapper.getConsultationByParentId(consultationId);
    }

    @Override
    public List<Consultation> getConsultationByTeacherId(Integer teacherId) {
        return consultationMapper.getConsultationByTeacherId(teacherId);
    }

    @Override
    public List<Consultation> getConsultationByStudentId(Integer studentId) {
        return consultationMapper.getConsultationByStudentId(studentId);
    }
}
