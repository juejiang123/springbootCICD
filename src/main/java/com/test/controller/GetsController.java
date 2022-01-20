package com.test.controller;

import com.test.domain.Phone;
import com.test.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GetsController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("name") String name){
        return "获取到的name是："+name;
    }

    @GetMapping("/hellotwo")
    @ResponseBody
    public String hello2(@RequestParam(value = "name",required =false) String name){
        return "获取到的name是："+name;
    }

    @GetMapping("/hellothree")
    @ResponseBody
    public String hello3(@RequestParam(value = "name",defaultValue = "hhhhahahaha") String name){
        return "获取到的name是："+name;
    }

    @GetMapping("/hellofour")
    @ResponseBody
    public String hello4(@RequestParam Map<String, Object> parms){
        return "获取到的name："+parms.get("name")+"<br>age:"+parms.get("age");
    }

    @GetMapping("/hellofive")
    @ResponseBody
    public String hello5(@RequestParam("name") String[] strings){
        String result = "";
        for (String s : strings){
            result +=  "获取到的name："+s+"<br>";
        }
        return result;
    }

    @GetMapping("/hellosix")
    @ResponseBody
    public String hello6(User user){
        return "name: "+user.getName()+"<br> password: "+user.getPassword();
    }

    @GetMapping("/helloseven")
    @ResponseBody
    public String hello7(@ModelAttribute("u") User user){
        return "name: "+user.getName()+"<br> password: "+user.getPassword();
    }

    @InitBinder("u")
    private void initBinder(WebDataBinder binder){
        binder.setFieldDefaultPrefix("u.");
    }

    @GetMapping("/helloeight")
    @ResponseBody
    public String hello8(User user, Phone phone){
        return "name: "+user.getName()
                + "<br> password: "+user.getPassword()
                + "<br> number: "+phone.getNumber();
    }



    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)
    @ResponseBody
    public String hello1(@RequestParam("name") String name){
        return "获取到的name是："+name;
    }


}
