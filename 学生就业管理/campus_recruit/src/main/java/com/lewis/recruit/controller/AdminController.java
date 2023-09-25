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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    protected static Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private PositionServiceImpl positionService;

    //跳转管理员主页
    @RequestMapping("/toIndex")
    public String toAdminIndex(){
        return "/admin/admin_index";
    }

    //注册管理员账号
    @RequestMapping("/register")
    public String register(Admin admin, Model model){
        logger.info("创建了学院管理员用户：" + admin);
        adminService.saveAdmin(admin);
        model.addAttribute("msg", "注册成功，请登录！");
        return "login";
    }

    //检测用户名是否可用
    @PostMapping("/check")
    @ResponseBody
    public String checkAccount(@RequestParam("adminAccount") String adminAccount, Map<String,Boolean> map){
        Admin admin = adminService.findAdminByAdminAccount(adminAccount);
        if (admin != null){
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

    //跳转修改密码页面
    @RequestMapping("/toAdminPwd")
    public String toUpdatePwd(Model model){
        //利用shiro获取当前用户信息
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("admin",admin);
        return "/admin/admin_update_pwd";
    }

    //修改密码
    @RequestMapping("/update/pwd")
    public String updatePwd(String newPassword,Model model){
        //利用shiro获取当前用户信息
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        adminService.updatePwd(admin, newPassword);
        logger.info("管理员：" + admin + "修改了密码");
        //修改成功后注销用户
        SecurityUtils.getSubject().logout();
        model.addAttribute("msg","您已修改密码，请重新登录！");
        return "login";
    }

    //跳转管理学生用户页面
    @RequestMapping("/manage/toStudentInfo")
    public String toStudentInfo(Model model){
        logger.info("管理员查询了所有学生用户信息");
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("studentList",studentList);
        return "/admin/admin_manage_student";
    }

    //删除学生用户
    @RequestMapping("/delete/student/{studentId}")
    public String deleteStudent(@PathVariable("studentId")Integer studentId){
        logger.info("管理员删除了学生用户：" + studentId);
        studentService.deleteStudentByStuId(studentId);
        return "redirect:/admin/manage/toStudentInfo";
    }

    //修改学生用户信息
    @RequestMapping("/update/student/{studentAccount}")
    public String updateStudentInfo(@PathVariable("studentAccount")String studentAccount, Model model){
        Student student = studentService.findStudentByStudentAccount(studentAccount);
        model.addAttribute("student",student);
        return "/admin/admin_student_update";
    }

    //跳转管理班主任用户页面
    @RequestMapping("/manage/toTeacherInfo")
    public String toTeacherInfo(Model model){
        logger.info("管理员查询了所有班主任用户信息");
        List<Teacher> teacherList = teacherService.getTeacherList();
        model.addAttribute("teacherList",teacherList);
        return "/admin/admin_manage_teacher";
    }

    //删除班主任用户
    @RequestMapping("/delete/teacher/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId")Integer teacherId){
        logger.info("管理员删除了学生用户：" + teacherId);
        teacherService.deleteTeacherById(teacherId);
        return "redirect:/admin/manage/toTeacherInfo";
    }

    //修改班主任用户信息
    @RequestMapping("/update/teacher/{teacherAccount}")
    public String updateTeacherInfo(@PathVariable("teacherAccount")String teacherAccount, Model model){
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacherAccount);
        model.addAttribute("teacher",teacher);
        return "/admin/admin_teacher_update";
    }

    //跳转管理企业用户页面
    @RequestMapping("/manage/toCompanyInfo")
    public String toCompanyInfo(Model model){
        logger.info("管理员查询了所有公司用户信息");
        List<Company> companyList = companyService.getCompanyList();
        model.addAttribute("companyList",companyList);
        return "/admin/admin_manage_company";
    }

    //删除企业用户
    @RequestMapping("/delete/company/{companyId}")
    public String deleteCompany(@PathVariable("companyId")Integer companyId){
        logger.info("管理员删除了企业用户：" + companyId);
        companyService.deleteCompany(companyId);
        return "redirect:/admin/manage/toCompanyInfo";
    }

    //修改公司用户信息
    @RequestMapping("/update/company/{companyAccount}")
    public String updateCompanyInfo(@PathVariable("companyAccount")String companyAccount, Model model){
        Company company = companyService.findCompanyByCompanyAccount(companyAccount);
        model.addAttribute("company",company);
        return "/admin/admin_company_update";
    }

    //跳转协助修改学生用户密码
    @RequestMapping("/update/toStudentPwd")
    public String toUpdateStudentPwd(){
        return "/admin/admin_update_student_pwd";
    }

    //跳转协助修改班主任用户密码
    @RequestMapping("/update/toTeacherPwd")
    public String toUpdateTeacherPwd(){
        return "/admin/admin_update_teacher_pwd";
    }

    //检测班主任用户是否存在
    @PostMapping("/teacher/check")
    @ResponseBody
    public String checkTeacherAccount(@RequestParam("teacherAccount") String teacherAccount, Map<String,Boolean> map){
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacherAccount);
        if (teacher == null){
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

    //检测企业用户是否存在
    @PostMapping("/company/check")
    @ResponseBody
    public String checkCompanyAccount(@RequestParam("companyAccount") String companyAccount, Map<String,Boolean> map){
        Company company = companyService.findCompanyByCompanyAccount(companyAccount);
        if (company == null){
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

    //协助修改班主任用户密码
    @RequestMapping("/update/teacherPwd")
    public String updateTeacherPwd(String teacherAccount, String newPassword){
        Teacher teacher = teacherService.findTeacherByTeacherAccount(teacherAccount);
        teacherService.updateTeacherPwd(teacher, newPassword);
        logger.info("管理员修改的账号名为：" + teacherAccount + "的学生用户的密码");
        return "redirect:/admin/toIndex";
    }

    //协助修改学生用户密码
    @RequestMapping("/update/studentPwd")
    public String updateStudentPwd(String studentAccount, String newPassword){
        Student student = studentService.findStudentByStudentAccount(studentAccount);
        studentService.updateStudentPwd(student, newPassword);
        logger.info("管理员修改的账号名为：" + studentAccount + "的学生用户的密码");
        return "redirect:/admin/toIndex";
    }

    //跳转协助修改公司用户密码
    @RequestMapping("/update/toCompanyPwd")
    public String toCompanyPwd(){
        return "/admin/admin_update_company_pwd";
    }

    //协助修改学生用户密码
    @RequestMapping("/update/companyPwd")
    public String updateCompanyPwd(String companyAccount, String newPassword){
        Company company = companyService.findCompanyByCompanyAccount(companyAccount);
        companyService.updateCompanyPwd(company, newPassword);
        logger.info("管理员修改的账号名为：" + companyAccount + "的企业用户的密码");
        return "redirect:/admin/toIndex";
    }

    //跳转管理职位信息页面
    @RequestMapping("/manage/toPositionInfo")
    public String toPositionInfo(Model model){
        logger.info("管理员查看了所有职位信息");
        List<Position> positionList = positionService.getPositionList();
        model.addAttribute("positionList",positionList);
        return "/admin/admin_manage_position";
    }

    //查看职位详情
    @RequestMapping("/search/position/{positionId}")
    public String toPositionDetail(@PathVariable("positionId")Integer positionId, Model model){
        logger.info("管理员查看了职位id为："+positionId+"的职位详情");
        Position position = positionService.getPositionByPositionId(positionId);
        model.addAttribute("position",position);
        return "/admin/admin_position_detail";
    }

    //跳转修改职位信息页面
    @RequestMapping("/update/position/{positionId}")
    public String toUpdatePosition(@PathVariable("positionId")Integer positionId, Model model){
        Position position = positionService.getPositionByPositionId(positionId);
        model.addAttribute("position",position);
        return "/admin/admin_update_position";
    }

    //跳转修改职位审核页面
    @RequestMapping("/audit/position/{positionId}")
    public String toAuditPosition(@PathVariable("positionId")Integer positionId, Model model){
        Position position = positionService.getPositionByPositionId(positionId);
        model.addAttribute("position",position);
        return "/admin/admin_audit_position";
    }

    //修改职位信息
    @RequestMapping("/update/position")
    public String updatePosition(Position position){
        positionService.updatePosition(position);
        logger.info("管理员修改了职位信息：" + position);
        return "redirect:/admin/manage/toPositionInfo";
    }

    //审核职位信息
    @RequestMapping("/audit/position")
    public String auditPosition(Position position){
        positionService.auditPosition(position);
        logger.info("管理员审核了职位信息：" + position);
        return "redirect:/admin/manage/toPositionInfo";
    }

    //删除职位信息
    @RequestMapping("/delete/position/{positionId}")
    public String deletePosition(@PathVariable("positionId")Integer positionId){
        positionService.deletePosition(positionId);
        logger.info("管理员删除了职位id为："+positionId+"的职位信息");
        return "redirect:/admin/manage/toPositionInfo";
    }

    //跳转添加学生用户
    @RequestMapping("/add/toStudentAdd")
    public String toStudentAdd(){
        return "/admin/admin_student_add";
    }

    //跳转添加班主任用户
    @RequestMapping("/add/toTeacherAdd")
    public String toTeacherAdd(){
        return "/admin/admin_teacher_add";
    }

    //跳转添加企业用户
    @RequestMapping("/add/toCompanyAdd")
    public String toCompanyAdd(){
        return "/admin/admin_company_add";
    }

    //跳转管理职位信息页面
    @RequestMapping("/toStatistical")
    public String toStatistical(Model model){
        StatisticalDto statisticalDto = new StatisticalDto();
        model.addAttribute("statistical",statisticalDto);
        model.addAttribute("type",1);
        return "/admin/admin_statistical";
    }

    //根据关键字搜索职位
    @RequestMapping("/getStatistical")
    public String getStatistical(@RequestParam("time") String time, @RequestParam("type") Integer type, Map<String,Object> map){
        StatisticalDto statisticalDto = new StatisticalDto();
        if (type == 1){
            statisticalDto = positionService.getStatisticalByYear(time);
        }else  if(type == 2){
            statisticalDto = positionService.getStatisticalByMonth(time);
        }
        map.put("statistical",statisticalDto);
        map.put("type",type);
        return "/admin/admin_statistical";
    }
}
