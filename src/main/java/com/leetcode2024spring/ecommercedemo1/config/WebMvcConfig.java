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


    @Override
    // when add path no /techCompare
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                // 拦截
                .addPathPatterns("/user/getWishlist")
                .addPathPatterns("/user/addWishlist")
                .addPathPatterns("/user/removeFromWishlist")
                .addPathPatterns("/products/sendreview")

                // 其他所有
                .excludePathPatterns("/**");
    }


}

