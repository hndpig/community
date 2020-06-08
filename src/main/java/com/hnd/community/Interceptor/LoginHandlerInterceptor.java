package com.hnd.community.Interceptor;

import com.hnd.community.bean.UserModel;
import com.hnd.community.service.UserServiceIfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    UserServiceIfac service;
    /**
     * 调用controller 之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie:Arrays.asList(cookies)){
                if ("token".equals(cookie.getName())) {
                    UserModel user = service.findUserByToken(cookie.getValue());
                    if(user==null) break;
                    request.getSession().setAttribute("user", user);
                    return true;
                }
            }
        }
        System.out.println("=====================拦截了===================");
        return false;
    }

    /**
     * 调用controller 之后 返回modelanview之前
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 调用controller 视图渲染完后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
