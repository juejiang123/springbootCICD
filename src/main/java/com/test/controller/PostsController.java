package com.test.controller;


import com.test.domain.Phone;
import com.test.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class PostsController {

    @PostMapping("/helloworld")//和下面的hello接口的结果一样
    @ResponseBody
    public String helloworld(@RequestParam String name,String age){

        return "name: "+ name +"<br>age: "+ age;
    }

    @PostMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("name") String name,@RequestParam("age") String age){

        return "name: "+ name +"<br>age: "+ age;
    }

    //接收字符串文本数据
    @PostMapping("/hellotext")
    @ResponseBody
    public String helloText(HttpServletRequest request){
//        request.setCharacterEncoding("utf-8");
        ServletInputStream is = null;
        try {

            is = request.getInputStream();
            StringBuilder builder = new StringBuilder();
            byte[] buf = new byte[1024];
            int len =0;
            while ((len =is.read(buf))!=-1){
                builder.append(new String(buf,0,len));
            }
            System.out.println(builder.toString());
            return "获得的文本内容是：" + builder.toString();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(is != null){
                    is.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return null;
    }

    //接收json数据
    @PostMapping("/hellojson")
    @ResponseBody
    public String helloJson(@RequestBody Map params){
        return "name: "+params.get("name")+"\n age: "+params.get("age");
    }

    //接收bean数据
    @PostMapping("/hellobean")
    @ResponseBody
    public String helloBean(@RequestBody Phone phone){
        return "number: "+phone.getNumber();
    }

    //接收list数据
    @PostMapping("/hellolist")
    @ResponseBody
    public String helloList(@RequestBody List<User> users){
        String result = "";
        for (User u : users){
            result+= u.getName()+u.getPassword()+"\n";
            System.out.println(result);
        }

        return result;
    }


}
