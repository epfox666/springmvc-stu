package com.epfox.controller;

import com.epfox.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }
    @RequestMapping("/a1")
    public void ajax1(String name, HttpServletResponse response) throws IOException {
        if("epfox".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }
    @RequestMapping("/a2")
    public List<User> ajax2(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("epfox1",1,"男"));
        userList.add(new User("epfox2",2,"男"));
        userList.add(new User("epfox3",3,"男"));
        userList.add(new User("epfox4",4,"男"));
        return userList;
    }
    @RequestMapping("/a3")
    public String ajax3(String name,String pwd){
        String msg ="";
        if (name!=null){
            if("admin".equals(name)){
                msg = "ok";
            }else{
                msg = "用户名有误";
            }
        }

        if (pwd!=null) {
            if ("123456".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
