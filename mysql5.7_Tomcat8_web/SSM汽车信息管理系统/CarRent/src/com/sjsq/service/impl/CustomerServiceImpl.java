package com.sjsq.service.impl;

import com.sjsq.mapper.CustomerMapper;
import com.sjsq.pojo.Customers;
import com.sjsq.pojo.Pagination;
import com.sjsq.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int addCustomer(Customers c) {
        return customerMapper.addCustomer(c);
    }

    @Override
    public Pagination<Customers> selCustomer(String identity, String custname, String phone, String page, String rows) {

        int p = Integer.parseInt(page);
        int r = Integer.parseInt(rows);

        List<Customers> list = customerMapper.selCustomer(identity, custname, phone, (p - 1) * r, r);
        int total = customerMapper.selCount();
        Pagination<Customers> pt = new Pagination<>();
        pt.setRows(list);
        pt.setTotal(total);
        return pt;
    }

    @Override
    public int upd(Customers c) {
        return customerMapper.upd(c);
    }

    @Override
    public int del(Integer identity) {
        return customerMapper.del(identity);
    }
}
