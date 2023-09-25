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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private ConsultationService consultationService;


    protected static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    //注册老师账号
    @RequestMapping("/register")
    public String register(Teacher teacher, Model model){
        logger.info("创建了老师用户：" + teacher);
        teacherService.saveTeacher(teacher);
        model.addAttribute("msg", "注册成功，请登录！");
        return "login";
    }

    //检测用户名是否可用
    @PostMapping("/check")
    @ResponseBody
    public String checkAccount(@RequestParam("teacherAccount") String teacherAccount, Map<String,Boolean> map){
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacherAccount);
        if (teacher != null){
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
        Boolean flag = teacherService.verifyOldPwd(oldPassword);
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

    //跳转班主任主页
    @RequestMapping("/toIndex")
    public String toTeaIndex(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        return "/teacher/teacher_index";
    }

    //跳转管理学生用户页面
    @RequestMapping("/manage/toStudentInfo")
    public String toStudentInfo(Model model){
        logger.info("老师查询了所有学生用户信息");
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        List<Student> studentList = studentService.getStudentListByClassG(teacher.getTeacherNo());
        model.addAttribute("studentList",studentList);
        return "/teacher/teacher_manage_student";
    }

    //修改学生用户信息
    @RequestMapping("/update/student/{studentAccount}")
    public String updateStudentInfo(@PathVariable("studentAccount")String studentAccount, Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        Student student = studentService.findStudentByStudentAccount(studentAccount);
        model.addAttribute("student",student);
        return "/teacher/teacher_student_update";
    }

    //删除学生用户
    @RequestMapping("/delete/student/{studentId}")
    public String deleteStudent(@PathVariable("studentId")Integer studentId){
        logger.info("老师删除了学生用户：" + studentId);
        studentService.deleteStudentByStuId(studentId);
        return "redirect:/teacher/manage/toStudentInfo";
    }

    //添加学生
    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        student.setStudentClassg(teacher_cur.getTeacherNo());
        studentService.saveStudent(student);
        return "redirect:/teacher/manage/toStudentInfo";
    }

    //修改个人资料
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student){
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        student.setStudentClassg(teacher_cur.getTeacherNo());
        studentService.updateStudent(student);
        return "redirect:/teacher/manage/toStudentInfo";
    }

    //检测学生用户是否存在
    @PostMapping("/student/check")
    @ResponseBody
    public String checkStudentAccount(@RequestParam("studentAccount") String studentAccount, Map<String,Boolean> map){
        Student student = studentService.findStudentByStudentAccount(studentAccount);
        if (student == null){
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

    //跳转添加学生用户
    @RequestMapping("/add/toStudentAdd")
    public String toStudentAdd(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        return "/teacher/teacher_student_add";
    }

    //跳转个人信息页面
    @RequestMapping("/toTeacherInfo")
    public String toTeacherInfo(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        //修改用户信息后要重新从数据库中查询数据，不然数据不会更新
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        return "/teacher/teacher_info";
    }
    //跳转修改密码页面
    @RequestMapping("/toTeacherPwd")
    public String toTeaInfoPwd(Map<String,Object> map){
        //利用shiro框架获取当前登录的用户
        Teacher teacher = (Teacher)SecurityUtils.getSubject().getPrincipal();
        map.put("teacher",teacher);
        return "/teacher/teacher_update_pwd";
    }
    //修改密码时验证原密码
    @RequestMapping("/verify")
    @ResponseBody
    public String verifyComPwd(@RequestParam("oldPassword")String oldPassword,Map<String,Object> map){
        //判断旧密码是否一致
        Boolean flag = teacherService.verifyComPwd(oldPassword);
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

    //修改公司用户密码
    @RequestMapping("/updateTeacherPwd")
    public String updateTeacherPwd(@RequestParam("newPassword") String newPassword, Model model){
        //获取当前用户
        Teacher teacher = (Teacher)SecurityUtils.getSubject().getPrincipal();
        teacherService.updateTeacherPwd(teacher, newPassword);
        logger.info("老师用户修改登录密码");

        model.addAttribute("msg","您已修改密码，请重新登录！");
        //情况当前登录用户的session
        SecurityUtils.getSubject().logout();
        return "/login";
    }
    //添加班主任
    @RequestMapping("/add")
    public String add(Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/admin/manage/toTeacherInfo";
    }

    //修改个人资料
    @RequestMapping("/updateTeacherAdmin")
    public String updateTeacherAdmin(Teacher teacher){
        logger.info("老师用户修改了个人资料");
        teacherService.updateTeacher(teacher);
        return "redirect:/admin/manage/toTeacherInfo";
    }

    //修改个人资料
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher){
        logger.info("老师用户修改了个人资料");
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher/toTeacherInfo";
    }
    //跳转管理职位信息页面
    @RequestMapping("/toStatistical")
    public String toStatistical(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        StatisticalDto statisticalDto = new StatisticalDto();
        model.addAttribute("statistical",statisticalDto);
        model.addAttribute("type",1);
        return "/teacher/teacher_statistical";
    }

    //根据关键字搜索职位
    @RequestMapping("/getStatistical")
    public String getStatistical(@RequestParam("time") String time, @RequestParam("type") Integer type, Map<String,Object> map){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        StatisticalDto statisticalDto = new StatisticalDto();
        if (type == 1){
            statisticalDto = positionService.getStatisticalByYearT(time,teacher_cur.getTeacherNo());
        }else  if(type == 2){
            statisticalDto = positionService.getStatisticalByMonthT(time,teacher_cur.getTeacherNo());
        }

        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        map.put("teacher",teacher);
        map.put("type",type);
        map.put("statistical",statisticalDto);
        return "/teacher/teacher_statistical";
    }

    //跳转咨询管理页面
    @RequestMapping("/toManageConsultation")
    public String toManageConsultation(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        List<Consultation> list = consultationService.getConsultationByTeacherId(teacher_cur.getTeacherId());
        model.addAttribute("consultationList",list);
        return "/teacher/teacher_consultation_manage";
    }

    //跳转咨询回复页面
    @RequestMapping("/reply/consultation/{consultationId}")
    public String toConsultationReply(@PathVariable("consultationId")Integer consultationId, Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacher_cur.getTeacherAccount());
        model.addAttribute("teacher",teacher);
        Consultation consultation = consultationService.getConsultationById(consultationId);
        model.addAttribute("consultation",consultation);
        List<Consultation> childList = consultationService.getConsultationByParentId(consultationId);
        model.addAttribute("childList",childList);
        return "/teacher/teacher_consultation_reply";
    }

    //回复
    @RequestMapping("/replaySub")
    public String replaySub(Consultation consultation, Model model){
        Teacher teacher_cur = (Teacher) SecurityUtils.getSubject().getPrincipal();
        Consultation consultation1 = new Consultation();
        consultation1.setContent(consultation.getContent());
        consultation1.setType(3);
        consultation1.setParentId(consultation.getConsultationId());
        consultation1.setTeacherId(teacher_cur.getTeacherId());
        consultationService.addConsultation(consultation1);
        model.addAttribute("msg","回复成功！");
        return "redirect:/teacher/toManageConsultation";
    }


}

