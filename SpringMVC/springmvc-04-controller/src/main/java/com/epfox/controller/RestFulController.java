package com.epfox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {

    //原来的： http://locahost:8080/add/?a=1&b=2
    //RestFul: http://locahost:8080/add/a/b
//    @RequestMapping("/add/{a}/{b}")
//    public String test1(@PathVariable int a, @PathVariable int b, Model model){
//        int res = a+b;
//        model.addAttribute("msg","结果为:"+res);
//        return "test";
//    }
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","结果为1:"+res);
        return "test";
    }
    @PostMapping("/add/{a}/{b}")
    public String test3(@PathVariable int a, @PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","结果为2:"+res);
        return "test";
    }
}
