package com.sjsq.mapper;

import com.sjsq.pojo.Customers;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerMapper {
    //添加客户信息
    @Insert("insert into customers values(#{identity},#{custname},#{sex},#{address},#{phone},#{career},#{custpwd})")
    int addCustomer(Customers c);

    //查询所有客户
    List<Customers> selCustomer(@Param("identity") String identity, @Param("custname") String custname, @Param("phone") String phone, @Param("start") int start, @Param("size") int size);

    // 查询客户总数
    @Select("select count(*) from customers")
    int selCount();

    //修改客户信息
    @Update("update customers set custname=#{custname},sex=#{sex},address=#{address},phone=#{phone},career=#{career},custpwd=#{custpwd} where identity=#{identity}")
    int upd(Customers c);

    //删除客户信息
    @Delete("delete from customers where identity=#{identity} ")
    int del(@Param("identity") Integer identity);
}
