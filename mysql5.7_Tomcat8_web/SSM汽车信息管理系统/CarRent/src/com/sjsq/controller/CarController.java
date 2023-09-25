package com.sjsq.controller;

import com.sjsq.pojo.Cars;
import com.sjsq.pojo.Pagination;
import com.sjsq.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    //添加汽车信息
    @RequestMapping("/addCar")
    @ResponseBody
    public int addCar(Cars c, @RequestParam("photo") MultipartFile photo, HttpServletRequest req) throws IllegalStateException, IOException {
        //得到原始名字
        String oname = photo.getOriginalFilename();
        File path = new File(req.getServletContext().getRealPath("/img"));
        // 判断路径是否存在
        if (!path.exists()) {
            path.mkdirs();
        }
        // 获取上传文件的后缀
        String suffix = oname.substring(oname.lastIndexOf("."));
        // 生成一个新的文件名
        String nname = UUID.randomUUID().toString() + suffix;
        // 真实的上传文件
        File file = new File(path, nname);
        // 上传文件
        photo.transferTo(file);
        c.setCarimg(nname);
        return carService.addCar(c);
    }

    //查询所有汽车
    @RequestMapping("/selAllCar")
    @ResponseBody
    public Pagination<Cars> selAllCar(Integer seat, String page, String rows) {
        return carService.selAllCar(seat, page, rows);
    }

    //修改汽车信息
    @RequestMapping("/updCar")
    @ResponseBody
    public int updCar(Cars c) {
        return carService.updCar(c);
    }

    //删除汽车信息
    @RequestMapping("/delCar")
    @ResponseBody
    public int delCar(String carnumber) throws UnsupportedEncodingException {
        String a = new String(carnumber.getBytes("iso-8859-1"), "utf-8");
        return carService.delCar(a);
    }

}
