package com.lewis.recruit.controller;

import com.lewis.recruit.pojo.*;
import com.lewis.recruit.service.*;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student/position")
public class PositionController {
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private DeliverServiceImpl deliverService;

    protected static Logger logger = LoggerFactory.getLogger(PositionController.class);
    //跳转搜索职位页面
    @RequestMapping("/toPositionSearch")
    public String toPositionSearch(Map<String,Object> map){
        logger.info("学生用户查询职位信息");
        List<Position> positions = positionService.getPositionYesList();
        map.put("positions",positions);
        return "/student/student_position_search";
    }
    //根据关键字搜索职位
    @RequestMapping("/getPositionByKey")
    public String getPositionByKey(@RequestParam("key") String key, Map<String,Object> map){
        logger.info("学生用户查询职位信息，搜索关键字为："+ key);
        List<Position> positions = positionService.getPositionByKey(key);
        map.put("positions",positions);
        return "/student/student_position_search";
    }

    //跳转非应届生就业页面
    @RequestMapping("/toPositionFresh")
    public String toPositionFresh(Map<String,Object> map){
        logger.info("学生用户查询职位信息");
        List<Position> positions = positionService.getPositionFreshList();
        map.put("positions",positions);
        return "/student/student_position_fresh";
    }
    //应届生就业根据关键字搜索职位
    @RequestMapping("/getPositionFreshByKey")
    public String getPositionFreshByKey(@RequestParam("key") String key, Map<String,Object> map){
        logger.info("学生用户查询职位信息，搜索关键字为："+ key);
        List<Position> positions = positionService.getPositionFreshByKey(key);
        map.put("positions",positions);
        return "/student/student_position_fresh";
    }


    //根据职位id查看职位详情
    @RequestMapping("/{positionId}")
    public String toPositionDetail(@PathVariable("positionId")Integer positionId,Map<String,Object> map){
        Student student = (Student) SecurityUtils.getSubject().getPrincipal();
        map.put("student",student);
        //通过职位信息id查询职位信息
        Position position = positionService.getPositionByPositionId(positionId);
        map.put("position",position);
        //根据学生id和职位id查询投递信息
        Deliver deliver = deliverService.getDeliverByStudentAndPosition(student.getStudentId(), positionId);
        map.put("deliver",deliver);
        return "/student/student_position_detail";
    }

    //根据公司id查询该公司所有发布职位
    @GetMapping("/getPositionByCompany/{positionCompany}")
    public String getPositionByCompany(@PathVariable("positionCompany")Integer positionCompany, Map<String,Object> map){
        Company company = companyService.getCompanyByCompanyId(positionCompany);
        map.put("company",company);
        logger.info("学生用户查询了"+company.getCompanyName()+"的全部职位");
        List<Position> positions = positionService.getPositionByCompanyId(positionCompany);
        map.put("positions",positions);
        return "/student/student_position_company";
    }

}
