package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.ZhuyuanService;
import com.demo.vo.Zhuyuan;
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
public class ZhuyuanController {

    @Autowired
    private ZhuyuanService zhuyuanService;

    /**
     * 增加住院
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("zhuyuanAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Zhuyuan vo = new Zhuyuan();
        //取出页面传进来的参数
        vo.setZhuyuanName(Util.decode(request, "zhuyuanName"));
        vo.setZhuyuanHao(Util.decode(request, "zhuyuanHao"));
        vo.setZhuyuanSex(Util.decode(request, "zhuyuanSex"));
        vo.setZhuyuanKeshi(Util.decode(request, "zhuyuanKeshi"));
        vo.setZhuyuanBingfanghao(Util.decode(request, "zhuyuanBingfanghao"));
        vo.setZhuyuanTime(Util.decode(request, "zhuyuanTime"));
        vo.setZhuyuanYishi(Util.decode(request, "zhuyuanYishi"));
        vo.setZhuyuanText(Util.decode(request, "zhuyuanText"));
        //调用Service层的增加（insert）方法
        zhuyuanService.insert(vo);
        this.redirectList(request, response);
    }

    /**
     * 删除住院
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("zhuyuanDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        zhuyuanService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    /**
     * 编辑住院
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("zhuyuanEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Zhuyuan vo = new Zhuyuan();
        vo.setId(Long.valueOf(Util.decode(request, "id")));
        vo.setZhuyuanName(Util.decode(request, "zhuyuanName"));
        vo.setZhuyuanHao(Util.decode(request, "zhuyuanHao"));
        vo.setZhuyuanSex(Util.decode(request, "zhuyuanSex"));
        vo.setZhuyuanKeshi(Util.decode(request, "zhuyuanKeshi"));
        vo.setZhuyuanBingfanghao(Util.decode(request, "zhuyuanBingfanghao"));
        vo.setZhuyuanTime(Util.decode(request, "zhuyuanTime"));
        vo.setZhuyuanYishi(Util.decode(request, "zhuyuanYishi"));
        vo.setZhuyuanText(Util.decode(request, "zhuyuanText"));
        zhuyuanService.update(vo);
        this.redirectList(request, response);
    }

    /**
     * 获取住院的详细信息（详情页面与编辑页面要显示该住院的详情）并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping({"zhuyuanGet", "zhuyuanEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//取出主键id
        Zhuyuan vo = zhuyuanService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//判断是去详情显示页面还是编辑页面
        response.sendRedirect("zhuyuan_" + to + ".jsp");
    }

    /**
     * 根据条件查询住院的列表并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("zhuyuanList")
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
        Map<String, Object> map = zhuyuanService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//根据查询条件取出对应的总记录数，用于分页
        String pageNum = Util.decode(request, "pageNum");//封装分页参数
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) zhuyuanService.list(params).get("list");//根据分页参数startIndex、pageSize查询出来的最终结果list
        pb.setServlet("zhuyuanList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("zhuyuan_list.jsp");
    }
}
