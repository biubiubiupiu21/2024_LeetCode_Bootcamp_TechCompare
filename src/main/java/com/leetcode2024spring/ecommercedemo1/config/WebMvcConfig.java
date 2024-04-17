package com.leetcode2024spring.ecommercedemo1.config;

import com.leetcode2024spring.ecommercedemo1.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .excludePathPatterns("/techCompare/user/login") // 排除登录接口
//                .addPathPatterns("/**"); // 拦截其他所有路径
//    }
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/techCompare/user/login") // 排除登录接口
//                .excludePathPatterns("/techCompare/user/register")
//                .excludePathPatterns("/techCompare/products/getall");
//                 // 拦截其他所有路径
//    }

}

