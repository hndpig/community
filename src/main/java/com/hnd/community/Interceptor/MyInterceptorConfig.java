package com.hnd.community.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer  {
    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;
    @Autowired
    UserIntercepter userIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor)
                .addPathPatterns("/wenti/**");
       /* List list = new ArrayList<String>();
        list.add("/");
        list.add("/static/**");*/
       registry.addInterceptor(userIntercepter).addPathPatterns("/**");
    }

}
