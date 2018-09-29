package com.shiro.dao;

import com.shiro.entity.User;
import java.util.Set;

public interface UserDao {

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    User selUserByUserName(String name);

    /**
     * 获取用户的角色
     * @param name
     * @return
     */
    Set<String> selRolesByUserName(String name);

    /**
     * 获取用户的权限
     * @param name
     * @return
     */
    Set<String> selPermissionsByUserName(String name);

}
