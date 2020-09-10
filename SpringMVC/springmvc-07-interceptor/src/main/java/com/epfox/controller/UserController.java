package com.epfox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/dologin")
    public String doLogin(){
        return "login";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/login")
    public String login(HttpSession session,String username,String pwd){
        System.out.println("登录的用户是："+username);
        session.setAttribute("loginuser",username);
        return "main";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {
        session.removeAttribute("loginuser");
        return "login";
    }
}

