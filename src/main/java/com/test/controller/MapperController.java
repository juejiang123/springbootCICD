package com.test.controller;


import com.test.domain.User;
import com.test.mapper.UserMapper;
import com.test.mapper.UserMapper2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@Api(value = "联表查",description = "这是我联合mybatis的查表操作")
public class MapperController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapper2 userMapper2;

    @RequestMapping("/query")
    @ResponseBody
    @ApiOperation(value = "通过这个方法可以获取user所有数据",httpMethod = "GET")
    public List<User> queryUser(){
        log.info("请求user所有数据");
        List<User> users = userMapper.queryUserList();
        return users;
    }

    @RequestMapping("/get")
    @ResponseBody
    @ApiOperation(value = "通过这个方法可以也获取user所有数据",httpMethod = "GET")
    public List<User> getUser(){
        List<User> users = userMapper2.getUser();

        return users;
    }

    @RequestMapping("/getname")
    @ResponseBody
    @ApiOperation(value = "通过这个方法可以也获取user所有数据",httpMethod = "GET")
    public String getName(@RequestParam String name){
        System.out.println(name);
        String name1 = userMapper2.getName(name);
        System.out.println(name1);
        System.out.println("执行了");
//        return "你好啊"+name1;
        return name1;
    }

    @RequestMapping("/getnames")
    @ResponseBody
    @ApiOperation(value = "通过这个方法可以获取name数据",httpMethod = "GET")
    public List<String> getNames(){

        List<String> names = userMapper2.getNames();
        if(Objects.isNull(names)){
            return null;
        }
        for (String s : names) {
            System.out.println(s);
        }
        return names;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    @ApiOperation(value = "addUser",httpMethod = "POST")
    public boolean insertUser(@RequestBody User user){
        Boolean aBoolean = userMapper.insertUser(user);
        return aBoolean;

    }
}
