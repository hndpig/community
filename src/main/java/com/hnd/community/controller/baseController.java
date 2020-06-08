package com.hnd.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnd.community.bean.ArticleAndcreatorModel;
import com.hnd.community.bean.ArticleModel;
import com.hnd.community.bean.Msg;
import com.hnd.community.bean.UserModel;
import com.hnd.community.service.FaBuWenTiServiceIfac;
import com.hnd.community.service.UserServiceIfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
public class baseController {
    @Autowired
    UserServiceIfac service;
    @Autowired
    FaBuWenTiServiceIfac service2;
    
    @RequestMapping ("/")
    public String index(HttpServletRequest request){
       Cookie[] cookies = request.getCookies();
       if(cookies!=null){
           Arrays.asList(cookies).forEach(cookie -> {
               System.out.println(cookie.getName());
               if ("token".equals(cookie.getName())) {
                   UserModel user = service.findUserByToken(cookie.getValue());
                   System.out.println("============baseController==============="+user);
                   request.getSession().setAttribute("user", user);
               }
           });
       }
        return "index";
    }

    @RequestMapping( value = {"/getArticles/{pn}","/getArticles"} ,method = RequestMethod.GET)
    @ResponseBody
    public Msg getArticles(@PathVariable(required = false) Integer pn){
        System.out.println(pn+"==============");
        PageInfo pageInfo = service2.getAllArticle(pn);
        return Msg.success().add("pageInfo",pageInfo);
    }



}
