package com.hnd.community.controller;

import com.hnd.community.bean.Msg;
import com.hnd.community.bean.UserModel;
import com.hnd.community.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;
    @RequestMapping("/quit")
    public String quit(HttpServletRequest request, HttpServletResponse response){
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        System.out.println("退出方法");
        for (Cookie cookie :cookies){
            System.out.println(cookie.getName());
            if("token".equals(cookie.getName())){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                request.getSession().removeAttribute("user");
            }
        }
        return "redirect:/";
    }
    @ResponseBody
    @RequestMapping("/getUser/{acountId}")
    public Msg getUser(@PathVariable(name = "acountId",required = true) String acountId){
        UserModel user = service.findUserById(acountId);
        return Msg.success().add("user",user);
    }
}

