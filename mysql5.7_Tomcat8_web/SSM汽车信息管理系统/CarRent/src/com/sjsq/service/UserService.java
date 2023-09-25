package com.sjsq.service;

import com.sjsq.pojo.Users;

import java.util.List;

public interface UserService {
    /**
     * 登录功能
     *
     * @param auth
     * @param password
     * @return
     */
    Users login(String auth, String userpwd);

    /**
     * 添加用户
     *
     * @param u
     * @return
     */
    public int addUser(Users u);

    /**
     * 查询所有用户
     *
     * @param u
     * @return
     */
    public List<Users> selUser(Users u);

    /**
     * 修改用户信息
     *
     * @param u
     * @return
     */
    public int updUser(Users u);

    /**
     * 删除用户
     *
     * @param identity
     * @return
     */
    public int delUser(String identity);
}
