package com.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {

    /**
     * 获取当前用户
     * @param fileName 文件路径
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public static Subject login(String fileName,String userName,String password){
        //读取配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(fileName);
        //获取SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //把SecurityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();

        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            //通过调用Subject.login(token)方法开始用户认证流程
            currentUser.login(token);
            System.out.println("认证成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("认证失败");
        }
        return currentUser;
    }
}
