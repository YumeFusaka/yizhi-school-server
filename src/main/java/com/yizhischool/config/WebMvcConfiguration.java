package com.yizhischool.config;

import com.yizhischool.interceptor.LoginCheckInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport{

    //自定义的拦截器对象
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    //注册自定义拦截器
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/student/**")
                .addPathPatterns("/general/**")
                .addPathPatterns("/teacher/**")
                .excludePathPatterns("/student/login")
                .excludePathPatterns("/student/hello")
                .excludePathPatterns("/teacher/login")
                .excludePathPatterns("/teacher/hello");
    }


    //设置静态资源映射
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始设置静态资源映射");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}