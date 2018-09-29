package com.shiro.controller;

import com.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping(value = "/doLogin")
    public String doLogin(User user,HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try {
            subject.login(token);
            System.out.println("登录了....");
            return "index";
        } catch (AuthenticationException e) {
           System.out.println("用户名或密码错误");
           return "login";
        }
    }

    @RequestMapping(value = "/selGrade")
    public String selGrade(@RequestParam("userName")String userName, @RequestParam("password")String password,
                           HttpServletRequest request, HttpServletResponse response){
        System.out.println("----------------------------");
        System.out.println(userName+"*"+password);
        System.out.println("----------------------------");
        //获取session
        HttpSession session = request.getSession();
        session.setAttribute("name",userName);
        return "result";
    }

    @RequestMapping(value = "/delStudent")
    @ResponseBody
    public String delStudent(){
       return "success";
    }

    @RequestMapping(value = "/updateStudent")
    @ResponseBody
    public String updateStudent(){
        return "fail";
    }

}
