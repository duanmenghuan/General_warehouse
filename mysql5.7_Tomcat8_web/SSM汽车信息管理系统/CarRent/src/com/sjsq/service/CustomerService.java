package com.sjsq.service;

import com.sjsq.pojo.Customers;
import com.sjsq.pojo.Pagination;

public interface CustomerService {
    /**
     * 添加用客户信息
     *
     * @param c
     * @return
     */
    public int addCustomer(Customers c);

    /**
     * 查询所有客户信息
     *
     * @param c
     * @return
     */
    public Pagination<Customers> selCustomer(String identity, String custname, String phone, String page, String rows);

    /**
     * 修改客户信息
     *
     * @param c
     * @return
     */
    public int upd(Customers c);

    /**
     * 删除客户信息
     *
     * @param identity
     * @return
     */
    public int del(Integer identity);
}
