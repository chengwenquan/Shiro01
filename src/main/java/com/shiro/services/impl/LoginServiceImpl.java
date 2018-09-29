package com.shiro.services.impl;

import com.shiro.dao.UserDao;
import com.shiro.entity.User;
import com.shiro.services.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDao userDao;

    public User selUserByUserName(String name) { return userDao.selUserByUserName(name); }

    public Set<String> selRolesByUserName(String name) {
        return userDao.selRolesByUserName(name);
    }

    public Set<String> selPermissionsByUserName(String name) {
        return userDao.selPermissionsByUserName(name);
    }
}
