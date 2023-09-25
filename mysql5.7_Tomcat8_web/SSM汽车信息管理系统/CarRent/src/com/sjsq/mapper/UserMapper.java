package com.sjsq.mapper;

import com.sjsq.pojo.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    //用户登录功能
    Users login(@Param("auth") String auth, @Param("userpwd") String userpwd);

    //添加用户
    @Insert("insert into users values(#{username},#{identity},#{fullname},#{sex},#{address},#{phone},#{position},#{userlevel},#{userpwd})")
    int addUser(Users u);

    //查询所有用户
    List<Users> selUser(Users u);

    //修改用户
    @Update("update users set username=#{username},fullname=#{fullname},sex=#{sex},address=#{address},phone=#{phone},position=#{position},userlevel=#{userlevel},userpwd=#{userpwd} where identity=#{identity}")
    int updUser(Users u);

    //删除用户
    @Delete("delete from users where identity=#{identity}")
    int delUser(@Param("identity") String identity);

}
