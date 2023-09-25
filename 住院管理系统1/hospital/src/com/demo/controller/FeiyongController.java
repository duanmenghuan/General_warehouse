package com.demo.controller;

import com.demo.util.Util;
import com.demo.service.FeiyongService;
import com.demo.vo.Feiyong;
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
public class FeiyongController {

    @Autowired
    private FeiyongService feiyongService;

    /**
     * 增加费用
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("feiyongAdd")
    public void add(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Feiyong vo = new Feiyong();
        //取出页面传进来的参数
        vo.setFeiyongNo(Util.decode(request, "feiyongNo"));
        vo.setFeiyongZhuyuanhao(Util.decode(request, "feiyongZhuyuanhao"));
        vo.setFeiyongName(Util.decode(request, "feiyongName"));
        vo.setFeiyongJine(Util.decode(request, "feiyongJine"));
        vo.setFeiyongJiaofeifangshi(Util.decode(request, "feiyongJiaofeifangshi"));
        vo.setFeiyongJiaofeishijian(Util.decode(request, "feiyongJiaofeishijian"));
        vo.setFeiyongText(Util.decode(request, "feiyongText"));
        //调用Service层的增加（insert）方法
        feiyongService.insert(vo);
        this.redirectList(request, response);
    }

    /**
     * 删除费用
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("feiyongDelete")
    public void delete(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");
        feiyongService.delete(Arrays.asList(id));
        this.redirectList(request, response);
    }

    /**
     * 编辑费用
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("feiyongEdit")
    public void edit(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Feiyong vo = new Feiyong();
        vo.setId(Long.valueOf(Util.decode(request, "id")));
        vo.setFeiyongNo(Util.decode(request, "feiyongNo"));
        vo.setFeiyongZhuyuanhao(Util.decode(request, "feiyongZhuyuanhao"));
        vo.setFeiyongName(Util.decode(request, "feiyongName"));
        vo.setFeiyongJine(Util.decode(request, "feiyongJine"));
        vo.setFeiyongJiaofeifangshi(Util.decode(request, "feiyongJiaofeifangshi"));
        vo.setFeiyongJiaofeishijian(Util.decode(request, "feiyongJiaofeishijian"));
        vo.setFeiyongText(Util.decode(request, "feiyongText"));
        feiyongService.update(vo);
        this.redirectList(request, response);
    }

    /**
     * 获取费用的详细信息（详情页面与编辑页面要显示该费用的详情）并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping({"feiyongGet", "feiyongEditPre"})
    public void get(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Serializable id = Util.decode(request, "id");//取出主键id
        Feiyong vo = feiyongService.get(id);
        request.getSession().setAttribute("vo", vo);
        String to = request.getRequestURI().toLowerCase().contains("get") ? "info" : "edit";//判断是去详情显示页面还是编辑页面
        response.sendRedirect("feiyong_" + to + ".jsp");
    }

    /**
     * 根据条件查询费用的列表并跳转回页面
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("feiyongList")
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
        Map<String, Object> map = feiyongService.list(params);
        request.getSession().setAttribute("list", map.get("list"));

        Integer totalRecord = (Integer) map.get("totalCount");//根据查询条件取出对应的总记录数，用于分页
        String pageNum = Util.decode(request, "pageNum");//封装分页参数
        com.demo.util.PageBean<Object> pb = new com.demo.util.PageBean(Integer.valueOf(pageNum != null ? pageNum : "1"), totalRecord);
        params.put("startIndex", pb.getStartIndex());
        params.put("pageSize", pb.getPageSize());
        List list = (List) feiyongService.list(params).get("list");//根据分页参数startIndex、pageSize查询出来的最终结果list
        pb.setServlet("feiyongList");
        pb.setSearchColumn(searchColumn);
        pb.setKeyword(keyword);
        pb.setList(list);
        request.getSession().setAttribute("pageBean", pb);
        request.getSession().setAttribute("list", pb.getList());

        response.sendRedirect("feiyong_list.jsp");
    }
}
