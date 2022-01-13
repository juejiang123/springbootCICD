package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Objects;

@Controller
public class QuickStartController {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "springboot 访问成功！";
    }

    @RequestMapping("/years")
    @ResponseBody
    public String getName(){
        return "18 years old";
    }

    @RequestMapping("/getCookie")
    @ResponseBody
    public String getCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        response.addHeader("contentType","text/plain");

        return "恭喜你登录成功";
    }

    @RequestMapping("/get/with/cookies")
    @ResponseBody
    public String needCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "必须携带cookie";
        }
        for(Cookie cookie : cookies){
            if(cookie.getName()=="login" && cookie.getValue()=="true"){
                return "cookie正常";
            }
        }
        return "cookie不匹配";

    }


    @RequestMapping("/get/with/param")
    @ResponseBody
    public HashMap<String, Integer> getWithParam(@RequestParam String name,@RequestParam Integer mem){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("lll",4);
        map.put("ddd",6);
        map.put("gg",40);
        if(name.equals("fangbianmian") && mem==4){
            return map;
        }
        return null;
    }

    @RequestMapping("/get/with/param/{name}/{mem}")
    @ResponseBody
    public HashMap<String, Integer> getWithParams(@PathVariable String name, @PathVariable Integer mem){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("lll",4);
        map.put("ddd",6);
        map.put("gg",40);
        if(name.equals("fangbianmian") && mem==4){
            return map;
        }
        return null;


    }
}
