package com.hnd.community.util;

import com.alibaba.fastjson.JSON;
import com.hnd.community.bean.GitTokenModel;
import com.hnd.community.bean.UserModel;
import com.hnd.community.service.impl.UserService;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class CallBack {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    public static final MediaType mediaType= MediaType.get("application/json; charset=utf-8");
    @Value("${client_id}")
    String client_id;
    @Value("${client_secret}")
    String client_secret;
    @Value("${access_token_url}")
    String access_token_url ;
    @Value("${gitHub_getUser_url}")
    String gitHub_getUser_url;
    @Autowired
    UserService service;
    static OkHttpClient client = new OkHttpClient();

    @RequestMapping("/callback")
    public String  callback(@RequestParam(name = "code") String code, @RequestParam("state") String state ){

        System.out.println("===================callback===============");
        System.out.println(client_id+"=="+client_secret+"===="+"access_token_url"+"==="+gitHub_getUser_url);



        GitTokenModel model = new GitTokenModel();
        model.setClient_id(client_id);
        model.setClient_secret(client_secret);
        model.setCode(code);
        //获取taken
       String str =  getToken(model);
       String token = str.substring((str.indexOf("=")+1),str.indexOf("&"));
        //获取授权,由授权后获得用户信息
        String msg =  getUserMsg(token);
        System.out.println(msg);
        //将用户信息填装入bean
        UserModel userModel = JSON.parseObject(msg, com.hnd.community.bean.UserModel.class);
        System.out.println("=============="+userModel);
        /*
        * 若有信息将信息插入数据库，持久化登录
        *
        * */
        if(userModel!=null){
            userModel.setToken(UUID.randomUUID().toString());
            userModel.setGmt_createTime(System.currentTimeMillis());
            userModel.setGmt_modity(userModel.getGmt_createTime());

            //将用户信息插入数据库，持久化登录
            Integer result = service.userLogin(userModel);
            if(result>0){
                Cookie cookie = new Cookie("token",userModel.getToken());

                response.addCookie(cookie);
            }
            return "redirect:/";
        }else{

            return "redirect:/";
        }


    }

    private String getToken(GitTokenModel model) {
        String json = JSON.toJSONString(model);

        RequestBody body = RequestBody.create(json,mediaType);
        Request request = new Request.Builder()
                .url(access_token_url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String str = response.body().string();
            System.out.println(str);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getUserMsg (String token){

            Request request = new Request.Builder()
                    .url(gitHub_getUser_url+"="+token)
                    .build();

        try {
            Response response = client.newCall(request).execute();
            String msg = response.body().string();
            return msg;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
