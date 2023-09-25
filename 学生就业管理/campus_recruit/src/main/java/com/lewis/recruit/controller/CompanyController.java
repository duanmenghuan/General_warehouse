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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private DeliverServiceImpl deliverService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private ConsultationService consultationService;

    protected static Logger logger = LoggerFactory.getLogger(CompanyController.class);
    //跳转公司主页
    @RequestMapping("/toIndex")
    public String toComIndex(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        return "/company/company_index";
    }

    //注册公司用户
    @RequestMapping("/register")
    public String registerCompany(Company company, Model model){
        logger.info("创建企业用户：" + company);
        companyService.saveCompany(company);
        model.addAttribute("msg", "注册成功，请登录！");
        return "login";
    }

    //检测用户名是否可用
    @PostMapping("/check")
    @ResponseBody
    public String checkAccount(@RequestParam("companyAccount") String companyAccount, Map<String,Boolean> map){
        Company company = companyService.findCompanyByCompanyAccount(companyAccount);
        if (company != null)
            map.put("valid",false);
        else
            map.put("valid",true);
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

    //跳转个人信息页面
    @RequestMapping("/toCompanyInfo")
    public String toCompanyInfo(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        //修改用户信息后要重新从数据库中查询数据，不然数据不会更新
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        return "/company/company_info";
    }

    //跳转修改密码页面
    @RequestMapping("/toCompanyPwd")
    public String toCompanyPwd(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        return "/company/company_update_pwd";
    }

    //添加企业
    @RequestMapping("/add")
    public String add(Company company){
        companyService.saveCompany(company);
        return "redirect:/admin/manage/toCompanyInfo";
    }

    //修改公司用户信息
    @RequestMapping("/updateCompanyAdmin")
    public String updateCompanyAdmin(Company company,Model model){
        System.out.println(company);
        companyService.updateCompany(company);
        return "redirect:/admin/manage/toCompanyInfo";
    }

    //修改公司用户信息
    @RequestMapping("/updateCompany")
    public String updateCompany(Company company,Model model){
        logger.info("企业用户"+company.getCompanyAccount()+"修改公司信息");
        companyService.updateCompany(company);
        return "redirect:/company/toCompanyInfo";
    }

    //修改密码时验证原密码
    @RequestMapping("/verify")
    @ResponseBody
    public String verifyComPwd(@RequestParam("oldPassword")String oldPassword,Map<String,Object> map){
        //判断旧密码是否一致
        Boolean flag = companyService.verifyComPwd(oldPassword);
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
    @RequestMapping("/updateCompanyPwd")
    public String updateComPwd(@RequestParam("newPassword") String newPassword, Model model){
        //获取当前用户
        Company company = (Company) SecurityUtils.getSubject().getPrincipal();
        companyService.updateCompanyPwd(company, newPassword);
        logger.info("企业用户修改登录密码");

        model.addAttribute("msg","您已修改密码，请重新登录！");
        //情况当前登录用户的session
        SecurityUtils.getSubject().logout();
        return "/login";
    }

    //跳转发布职位页面
    @RequestMapping("/toPublishPosition")
    public String toPublishPosition(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        return "/company/company_position_publish";
    }

    //发布职位
    @RequestMapping("/addPosition")
    public String publishPosition(Position position, Model model){

        positionService.addPosition(position);
        model.addAttribute("msg","发布成功！");
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        logger.info("企业用户："+company.getCompanyAccount()+"发布了职位："+position);
        model.addAttribute("company",company);
        return "/company/company_index";
    }

    //跳转职位管理页面
    @RequestMapping("/toManagePublish")
    public String toManagePublish(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        List<Position> positionList = positionService.getPositionByCompanyId(company_cur.getCompanyId());
        model.addAttribute("positionList",positionList);
        return "company/company_position_manage";
    }

    //跳转职位投递状态页面
    @RequestMapping("/toGetPositionDeliver")
    public String toGetPositionDeliver(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        List<Position> positionList = positionService.getPositionByCompanyId(company.getCompanyId());
        model.addAttribute("positionList",positionList);
        return "company/company_position_deliver";
    }

    //删除职位
    @RequestMapping("/delete/position/{positionId}")
    public String deletePosition(@PathVariable("positionId") Integer positionId){
        logger.info("企业用户删除了职位，id为：" + positionId);
        positionService.deletePosition(positionId);
        return "redirect:/company/toManagePublish";
    }

    //查看职位
    @RequestMapping("/search/position/{positionId}")
    public String searchPosition(@PathVariable("positionId") Integer positionId,Model model){
        Position position = positionService.getPositionByPositionId(positionId);
        model.addAttribute("position",position);
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        return "/company/company_position_detail";
    }

    //跳转修改职位信息页面
    @RequestMapping("/update/position/{positionId}")
    public String toUpdatePosition(@PathVariable("positionId") Integer positionId,Model model){
        Position position = positionService.getPositionByPositionId(positionId);
        model.addAttribute("position",position);
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        return "/company/company_position_update";
    }

    //修改职位
    @RequestMapping("/updatePosition")
    public String updatePosition(Position position){
        logger.info("企业用户修改了职位信息：" + position);
        positionService.updatePosition(position);
        return "redirect:/company/toManagePublish";
    }

    //跳转查看简历页面
    @RequestMapping("/position/resume/{positionId}")
    public String toPositionResume(@PathVariable("positionId")Integer positionId, Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        List<Student> studentList = studentService.getStudentByPositionId(positionId);
        model.addAttribute("studentList",studentList);
        return "/company/company_position_resume";
    }

    //审核
    @RequestMapping("/audit/resume/{studentId}")
    public String audit(@PathVariable("studentId") Integer studentId, @RequestParam("positionId")Integer positionId, @RequestParam("result")String result, Model model){
        //公司用户查看详细简历信息后，把投递记录状态修改为已查看
        deliverService.updateDeliverStateByPositionAndStudent(positionId, studentId,result);

        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        List<Student> studentList = studentService.getStudentByPositionId(positionId);
        model.addAttribute("studentList",studentList);
        return "/company/company_position_resume";
    }

    //跳转咨询管理页面
    @RequestMapping("/toManageConsultation")
    public String toManageConsultation(Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        List<Consultation> list = consultationService.getConsultationByCompanyId(company_cur.getCompanyId());
        model.addAttribute("consultationList",list);
        return "company/company_consultation_manage";
    }

    //跳转咨询回复页面
    @RequestMapping("/reply/consultation/{consultationId}")
    public String toConsultationReply(@PathVariable("consultationId")Integer consultationId, Model model){
        //利用shrio获取当前登录页用户，并获取登录用户的信息
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Company company = companyService.findCompanyByCompanyAccount(company_cur.getCompanyAccount());
        model.addAttribute("company",company);
        Consultation consultation = consultationService.getConsultationById(consultationId);
        model.addAttribute("consultation",consultation);
        List<Consultation> childList = consultationService.getConsultationByParentId(consultationId);
        model.addAttribute("childList",childList);
        return "/company/company_consultation_reply";
    }

    //回复
    @RequestMapping("/replaySub")
    public String replaySub(Consultation consultation, Model model){
        Company company_cur = (Company) SecurityUtils.getSubject().getPrincipal();
        Consultation consultation1 = new Consultation();
        consultation1.setContent(consultation.getContent());
        consultation1.setType(2);
        consultation1.setParentId(consultation.getConsultationId());
        consultation1.setCompanyId(company_cur.getCompanyId());
        consultationService.addConsultation(consultation1);
        model.addAttribute("msg","回复成功！");
        return "redirect:/company/toManageConsultation";
    }

}
