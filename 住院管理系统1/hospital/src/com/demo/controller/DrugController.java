package com.demo.controller;

import com.demo.service.DrugService;
import com.demo.service.UserService;
import com.demo.util.Util;
import com.demo.vo.Drug;
import com.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class DrugController {

    @Autowired
    private DrugService drugService;


    @RequestMapping("drugList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }


    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询列和关键字
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//用来保存控制层传进来的参数(查询条件)
        params.put("searchColumn", searchColumn);//要查询的列
        params.put("keyword", keyword);//查询的关键字
        Map<String, Object> map = drugService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//根据查询条件取出对应的总记录数，用于分页
        String pageNum = Util.decode(request, "pageNum");//封装分页参数
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) drugService.list(params).get("list");//根据分页参数startIndex、pageSize查询出来的最终结果list
        pb.setServlet("userList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("drug_list.jsp");
    }


    @RequestMapping({"drugGet", "drugEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//取出主键id
        Drug vo = drugService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//判断是去详情显示页面还是编辑页面
        response.sendRedirect("drug_" + to + ".jsp");
    }



    @RequestMapping("drugAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Drug vo = new Drug();
        //取出页面传进来的参数
        vo.setName(Util.decode(request, "name"));
        vo.setSupplier(Util.decode(request, "supplier"));
        vo.setInitialtime(Util.decode(request, "initialtime"));
        vo.setExpirationdate(Util.decode(request, "expirationdate"));
        vo.setPesticideeffect(Util.decode(request, "pesticideeffect"));
        vo.setRemark(Util.decode(request, "remark"));
        //调用Service层的增加（insert）方法
        drugService.insert(vo);
        this.redirectList(request, response);
    }


    @RequestMapping("drugEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Drug vo = new Drug();
        vo.setId(Long.valueOf(Util.decode(request, "id")));
        vo.setName(Util.decode(request, "name"));
        vo.setSupplier(Util.decode(request, "supplier"));
        vo.setInitialtime(Util.decode(request, "initialtime"));
        vo.setExpirationdate(Util.decode(request, "expirationdate"));
        vo.setPesticideeffect(Util.decode(request, "pesticideeffect"));
        vo.setRemark(Util.decode(request, "remark"));
        drugService.update(vo);
        this.redirectList(request, response);
    }






    @RequestMapping("drugDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        drugService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }






}
