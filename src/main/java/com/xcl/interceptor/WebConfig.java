package com.xcl.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        // 设置静态资源路径，让拦截器不要拦截静态资源，否则，CSS,html等会无法加载
//        // 该路径也可以设置多个，组成静态资源链
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}
