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
        //��ѯ�к͹ؼ���
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//����������Ʋ㴫�����Ĳ���(��ѯ����)
        params.put("searchColumn", searchColumn);//Ҫ��ѯ����
        params.put("keyword", keyword);//��ѯ�Ĺؼ���
        Map<String, Object> map = drugService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//���ݲ�ѯ����ȡ����Ӧ���ܼ�¼�������ڷ�ҳ
        String pageNum = Util.decode(request, "pageNum");//��װ��ҳ����
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) drugService.list(params).get("list");//���ݷ�ҳ����startIndex��pageSize��ѯ���������ս��list
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
        Serializable id = Util.decode(request, "id");//ȡ������id
        Drug vo = drugService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//�ж���ȥ������ʾҳ�滹�Ǳ༭ҳ��
        response.sendRedirect("drug_" + to + ".jsp");
    }



    @RequestMapping("drugAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Drug vo = new Drug();
        //ȡ��ҳ�洫�����Ĳ���
        vo.setName(Util.decode(request, "name"));
        vo.setSupplier(Util.decode(request, "supplier"));
        vo.setInitialtime(Util.decode(request, "initialtime"));
        vo.setExpirationdate(Util.decode(request, "expirationdate"));
        vo.setPesticideeffect(Util.decode(request, "pesticideeffect"));
        vo.setRemark(Util.decode(request, "remark"));
        //����Service������ӣ�insert������
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
