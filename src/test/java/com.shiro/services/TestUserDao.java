package com.shiro.services;

import com.shiro.dao.UserDao;
import com.shiro.services.impl.LoginServiceImpl;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

public class TestUserDao extends TestUtil{

    @Resource
    private UserDao userDao;
    @Resource
    private LoginService loginService;

    @Test
    public void test1(){
        System.out.println("-------------------------------------");
        System.out.println(userDao.selUserByUserName("admin"));
        System.out.println("-------------------------------------");
        Set<String> set_role = userDao.selRolesByUserName("admin");
        Iterator<String> it = set_role.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------------------------------");
        Set<String> set_p = userDao.selPermissionsByUserName("admin");
        Iterator<String> it1 = set_p.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }
    }
    @Test
    public void test2(){
        loginService.selUserByUserName("admin");

    }

}
