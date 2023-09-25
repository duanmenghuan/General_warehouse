package com.sjsq.controller;

import com.sjsq.pojo.Customers;
import com.sjsq.pojo.Pagination;
import com.sjsq.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //添加客户信息
    @RequestMapping("/addCustomer")
    @ResponseBody
    public int addCustomer(Customers c) {
        return customerService.addCustomer(c);
    }

    //查询客户信息
    @RequestMapping("/selCustomer")
    @ResponseBody
    public Pagination<Customers> selCustomer(String identity, String custname, String phone, String rows, String page) {
        return customerService.selCustomer(identity, custname, phone, page, rows);
    }

    //修改客户信息
    @RequestMapping("/upd")
    @ResponseBody
    public int upd(Customers c) {
        return customerService.upd(c);
    }

    //删除客户信息
    @RequestMapping("/del")
    @ResponseBody
    public int del(Integer identity) {
        return customerService.del(identity);
    }
}
