package com.lewis.recruit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lewis.recruit.pojo.*;
import com.lewis.recruit.service.*;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private DeliverServiceImpl deliverService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private ConsultationService consultationService;

    protected static Logger logger = LoggerFactory.getLogger(StudentController.class);

    //注册学生账号
    @RequestMapping("/register")
    public String register(Student student, Model model){
        logger.info("创建了学生用户：" + student);
        studentService.saveStudent(student);
        model.addAttribute("msg", "注册成功，请登录！");
        return "login";
    }

    //检测用户名是否可用
    @PostMapping("/check")
    @ResponseBody
    public String checkAccount(@RequestParam("studentAccount") String studentAccount, Map<String,Boolean> map){
        Student student = studentService.findStudentByStudentAccount(studentAccount);
        if (student != null){
            map.put("valid",false);
        } else{
            map.put("valid",true);
        }
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            //将传入的对象序列化为json，返回给调用者
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    //验证学生修改密码时，旧密码输入是否正确
    @PostMapping(value = "/verify")
    @ResponseBody
    public String verifyOldPwd(@RequestParam("oldPassword") String oldPassword,Map<String,Boolean> map){
        Boolean flag = studentService.verifyOldPwd(oldPassword);
        if (flag){
            map.put("valid",true);
        }else {
            map.put("valid",false);
        }
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            //将传入的对象序列化为json，返回给调用者
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    //跳转学生主页
    @RequestMapping("/toIndex")
    public String toStuIndex(){
        return "/student/student_index";
    }


    //修改学生密码
    @RequestMapping("/updateStudentByStuId")
    public String updateStuPwd(String newPassword,Model model){
        //利用shiro框架获取当前登录的用户
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        //调用修改学生密码的方法
        studentService.updateStudentPwd(student, newPassword);
        logger.info("学生用户修改了密码");
        //清空当前登录用户的session
        SecurityUtils.getSubject().logout();
        model.addAttribute("msg","您已修改密码，请重新登录！");
        return "login";
    }

    //跳转修改密码页面
    @RequestMapping("/toStuInfoPwd")
    public String toStuInfoPwd(Map<String,Object> map){
        //利用shiro框架获取当前登录的用户
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        map.put("student",student);
        return "/student/student_info_pwd";
    }
    //跳转管理简历页面
    @RequestMapping("/toStuInfoResume")
    public String toStuInfoResume(Map<String,Object> map){
        //利用shiro框架获取当前登录的用户
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        map.put("student",studentService.findStudentByStudentAccount(student.getStudentAccount()));
        return "/student/student_info_resume";
    }
    //跳转我的申请页面
    @RequestMapping("/toStuInfoApply")
    public String toStuInfoApply(Map<String,Object> map){
        //获取简历id，用去查询所有投递信息
        List<Deliver> deliverList = deliverService.getDeliverByResumeId();
        map.put("deliverList",deliverList);
        //利用shiro框架获取当前登录的用户
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        map.put("student",studentService.findStudentByStudentAccount(student.getStudentAccount()));
        return "/student/student_info_apply";
    }
    //跳转我的咨询页面
    @RequestMapping("/toConsultation")
    public String toConsultation(Map<String,Object> map){
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();

        List<Consultation> list = consultationService.getConsultationByStudentId(student.getStudentId());
        map.put("consultationList",list);
        //利用shiro框架获取当前登录的用户
        map.put("student",studentService.findStudentByStudentAccount(student.getStudentAccount()));
        return "/student/student_info_consultation";
    }

    //添加学生
    @RequestMapping("/add")
    public String add(Student student){
        studentService.saveStudent(student);
        return "redirect:/admin/manage/toStudentInfo";
    }

    //修改个人资料
    @RequestMapping("/updateStudentAdmin")
    public String updateStudentAdmin(Student student){
        studentService.updateStudent(student);
        return "redirect:/admin/manage/toStudentInfo";
    }

    //修改个人资料
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        logger.info("学生用户修改了个人资料");
        studentService.updateStudent(student);
        return "redirect:/student/toStuInfoResume";
    }

    //投递简历
    @RequestMapping("/deliverResume")
    public String deliverResume(Deliver deliver){
        logger.info("学生投递了简历");
        deliverService.addDeliver(deliver);
        return "redirect:/student/position/" + deliver.getPositionId();
    }

    //选择企业
    @RequestMapping("/audit/{deliverId}")
    public String audit(@PathVariable("deliverId") Integer deliverId){
        Deliver deliver = deliverService.getDeliverById(deliverId);
        Student student = studentService.findStudentById(deliver.getStudentId());
        student.setStudentEmployment(2);
        Company company = companyService.findCompanyById(deliver.getCompanyId());
        student.setEmployment(company.getCompanyName());
        studentService.updateStudent(student);
        return "redirect:/student/toStuInfoApply";
    }

    //跳转咨询回复页面
    @RequestMapping("/reply/consultation/{consultationId}")
    public String toConsultationReply(@PathVariable("consultationId")Integer consultationId, Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("student",student);
        Consultation consultation = consultationService.getConsultationById(consultationId);
        model.addAttribute("consultation",consultation);
        List<Consultation> childList = consultationService.getConsultationByParentId(consultationId);
        model.addAttribute("childList",childList);
        return "/student/student_info_consultation_reply";
    }

    //回复
    @RequestMapping("/replaySub")
    public String replaySub(Consultation consultation, Model model){
        Student student = (Student)SecurityUtils.getSubject().getPrincipal();
        Consultation consultation1 = new Consultation();
        consultation1.setContent(consultation.getContent());
        consultation1.setType(1);
        consultation1.setParentId(consultation.getConsultationId());
        consultation1.setStudentId(student.getStudentId());
        consultationService.addConsultation(consultation1);
        model.addAttribute("msg","回复成功！");
        return "redirect:/student/toConsultation";
    }
}

