package com.sjsq.service.impl;

import com.sjsq.mapper.UserMapper;
import com.sjsq.pojo.Users;
import com.sjsq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users login(String auth, String userpwd) {
        return userMapper.login(auth, userpwd);
    }

    @Override
    public int addUser(Users u) {
        return userMapper.addUser(u);
    }

    @Override
    public List<Users> selUser(Users u) {
        return userMapper.selUser(u);
    }

    @Override
    public int updUser(Users u) {
        return userMapper.updUser(u);
    }

    @Override
    public int delUser(String identity) {
        return userMapper.delUser(identity);
    }
}
