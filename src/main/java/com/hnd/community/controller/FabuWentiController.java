package com.hnd.community.controller;


import com.hnd.community.bean.ArticleModel;
import com.hnd.community.bean.Msg;
import com.hnd.community.bean.UserModel;
import com.hnd.community.service.FaBuWenTiServiceIfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Enumeration;
import java.util.List;


@Controller
@RequestMapping("/wenti")
public class FabuWentiController {
    @Autowired
    FaBuWenTiServiceIfac service;

    /**
     * 进入发布问题主页
     *
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String wentiFabu(){
        System.out.println("=============进入问题描述模块=======");


        return "fabuwenti";
    }
    /*
    * 提交表单
    * */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public Msg subArticle(@Valid ArticleModel articleModel , BindingResult reuslt, HttpServletRequest request){
        System.out.println(articleModel);
        List<ObjectError> erros = reuslt.getAllErrors();
        System.out.println("==================="+erros.size());
        for(ObjectError erro :erros){
            System.out.println(erro.getDefaultMessage());
        }

        if (erros.size()!=0){
            return Msg.fail().add("erros",erros);
        }


        System.out.println(articleModel);

        UserModel model =  (UserModel) request.getSession().getAttribute("user");
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String s = attributeNames.nextElement().toString();
            // 根据键值取session中的值
            Object value = request.getSession().getAttribute(s);
            // 打印结果
            System.out.println("==========" + s + "========" + value );

        }

        System.out.println("============FabuWentiController============"+model);
        Integer num = service.addArticle(articleModel,model);
        System.out.println("执行的sql影响条数"+num);

        return num>0?Msg.success():Msg.fail();
    }
    @RequestMapping("/getHotTags")
    @ResponseBody
    public Msg getHotTags(){
        List<String> hotTags = service.getHotTags();
        return Msg.success().add("hotTags",hotTags);
    }



}
