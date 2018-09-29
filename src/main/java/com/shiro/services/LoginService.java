package com.shiro.services;

import com.shiro.entity.User;

import java.util.Set;

public interface LoginService {

    User selUserByUserName(String name);

    Set<String> selRolesByUserName(String name);

    Set<String> selPermissionsByUserName(String name);


}
