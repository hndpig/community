package com.hnd.community.Interceptor;


import com.hnd.community.bean.UserModel;
import com.hnd.community.service.UserServiceIfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class UserIntercepter implements HandlerInterceptor {
    @Autowired
    UserServiceIfac service;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie: Arrays.asList(cookies)){
                if ("token".equals(cookie.getName())) {
                    UserModel user = service.findUserByToken(cookie.getValue());
                    if(user==null) break;
                    request.getSession().setAttribute("user", user);
                }
            }
        }
        return true;
    }
}
