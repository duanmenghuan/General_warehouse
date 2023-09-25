package com.lewis.recruit.controller;

import com.lewis.recruit.pojo.*;
import com.lewis.recruit.service.CompanyServiceImpl;
import com.lewis.recruit.service.ConsultationService;
import com.lewis.recruit.service.DeliverServiceImpl;
import com.lewis.recruit.service.PositionServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    protected static Logger logger = LoggerFactory.getLogger(ConsultationController.class);

    //咨询
    @RequestMapping("/add")
    public String add(Consultation consultation){
        Student student = (Student) SecurityUtils.getSubject().getPrincipal();
        logger.info("学生咨询了职位");
        consultation.setType(1);
        consultation.setStudentId(student.getStudentId());
        consultationService.addConsultation(consultation);
        return "redirect:/student/position/" + consultation.getPositionId();
    }
}
