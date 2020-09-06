package com.epfox.controller;

import com.alibaba.fastjson.JSON;
import com.epfox.pojo.User;
import com.epfox.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController  //他就不会走视图解析器，会直接返回一个字符串
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody  //需要配合Controller使用 他就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        //创建一个对象
        User user = new User("Epfox",12,"男");

        //jackson，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(user);
        return str;
//        return user.toString();
    }
    @RequestMapping("/j2")
    //@ResponseBody  //需要配合Controller使用 他就不会走视图解析器，会直接返回一个字符串
    public String json2() throws JsonProcessingException {
        //创建一个对象
        User user1 = new User("Epfox1",12,"男");
        User user2 = new User("Epfox2",12,"男");
        User user3 = new User("Epfox3",12,"男");
        User user4 = new User("Epfox4",12,"男");

        //jackson，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = objectMapper.writeValueAsString(userList);
        return str;

    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Date date = new Date();
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return mapper.writeValueAsString(sdf.format(date));

    }
    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();


        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        Date date = new Date();
        return mapper.writeValueAsString(date);

    }
    @RequestMapping("/j33")
    public String json33() throws JsonProcessingException {

        User user = new User("Epfox",12,"男");
        return JsonUtils.getJson(user);

    }

    @RequestMapping("/j44")
    public String json44() throws JsonProcessingException {

        Date date = new Date();
        return JsonUtils.getJson(date);

    }
    @RequestMapping("/j5")
    public String json5() throws JsonProcessingException {

        //创建一个对象
        User user1 = new User("Epfox1",12,"男");
        User user2 = new User("Epfox2",12,"男");
        User user3 = new User("Epfox3",12,"男");
        User user4 = new User("Epfox4",12,"男");


        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JSON.toJSONString(userList);

    }


}
