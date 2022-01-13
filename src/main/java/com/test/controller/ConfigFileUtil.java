package com.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix = "person")
@Api(value = "/",description = "哈哈哈")
public class ConfigFileUtil {

//    @Value("${person.name}")
    private String name;
//    @Value("${person.age}")
    private Integer age;

    private static Logger logger = LoggerFactory.getLogger(ConfigFileUtil.class);


    @RequestMapping("/quickStart")
    @ResponseBody
    @ApiOperation(value = "配置",httpMethod = "GET")
    public String quick(){

        logger.info("这是springboot启动工程");

        return "Springboot 访问成功！ name=:"+name+",age:"+age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
