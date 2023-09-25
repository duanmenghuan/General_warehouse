package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.BingfangService;
import com.demo.vo.Bingfang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class BingfangController {

    @Autowired
    private BingfangService bingfangService;

    /**
     * 增加病房
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("bingfangAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Bingfang vo = new Bingfang();
        //取出页面传进来的参数
        vo.setBingfangNo(Util.decode(request, "bingfangNo"));
        vo.setBingfangName(Util.decode(request, "bingfangName"));
        vo.setBingfangType(Util.decode(request, "bingfangType"));
        vo.setBingfangCount(Util.decode(request, "bingfangCount"));
        vo.setBingfangPrice(Util.decode(request, "bingfangPrice"));
        vo.setBingfangText(Util.decode(request, "bingfangText"));
        //调用Service层的增加（insert）方法
        bingfangService.insert(vo);
        this.redirectList(request, response);
    }

    /**
     * 删除病房
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("bingfangDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        bingfangService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    /**
     * 编辑病房
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("bingfangEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Bingfang vo = new Bingfang();
        vo.setId(Long.valueOf(Util.decode(request, "id")));
        vo.setBingfangNo(Util.decode(request, "bingfangNo"));
        vo.setBingfangName(Util.decode(request, "bingfangName"));
        vo.setBingfangType(Util.decode(request, "bingfangType"));
        vo.setBingfangCount(Util.decode(request, "bingfangCount"));
        vo.setBingfangPrice(Util.decode(request, "bingfangPrice"));
        vo.setBingfangText(Util.decode(request, "bingfangText"));
        bingfangService.update(vo);
        this.redirectList(request, response);
    }

    /**
     * 获取病房的详细信息（详情页面与编辑页面要显示该病房的详情）并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping({"bingfangGet", "bingfangEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//取出主键id
        Bingfang vo = bingfangService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//判断是去详情显示页面还是编辑页面
        response.sendRedirect("bingfang_" + to + ".jsp");
    }

    /**
     * 根据条件查询病房的列表并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("bingfangList")
    public void list(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.redirectList(request, response);
    }

    /**
     * 跳转到列表页面
     *
     * @param request
     * @param response
     */
    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询列和关键字
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//用来保存控制层传进来的参数(查询条件)
        params.put("searchColumn", searchColumn);//要查询的列
        params.put("keyword", keyword);//查询的关键字
        Map<String, Object> map = bingfangService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//根据查询条件取出对应的总记录数，用于分页
        String pageNum = Util.decode(request, "pageNum");//封装分页参数
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) bingfangService.list(params).get("list");//根据分页参数startIndex、pageSize查询出来的最终结果list
        pb.setServlet("bingfangList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("bingfang_list.jsp");
    }
}
