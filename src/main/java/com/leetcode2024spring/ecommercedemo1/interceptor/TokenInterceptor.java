package com.leetcode2024spring.ecommercedemo1.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
@CrossOrigin(origins = "http://localhost:3000")
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Request URI: " + request.getRequestURI());
        if (request.getRequestURI().endsWith("/login")) {
            System.out.println("Login path, should not be intercepted.");
        }
        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            // 获取指定头部的值
//            String headerValue = request.getHeader(headerName);
//            // 打印头部名称和值
//            System.out.println(headerName + ": " + headerValue);
//        }
        String token = request.getHeader("auth");
        System.out.println("auth_token: "+token);
        // 获取特定头部的值
        String tokens = request.getHeader("access-control-request-headers");
        System.out.println("tokens: "+tokens);

//        String[] token = tokens.split(",");
        boolean flag =false;
        if (tokens!=null){
            String[] tokenss = tokens.split(",");
            for (String each: tokenss){
                if (each.equals("signin")){
                    flag = true;
                    break;
                }
            }
        }
//        for (String each: token){
//            if (each.equals("auth")){
//                flag = true;
//                break;
//            }
//        }
//        String token3 = request.getHeader("authorization");
//        System.out.println("token: "+token3);
//

        System.out.println("flag: "+flag);
        if ((token!=null && !token.equals("signin")) && flag == false) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        System.out.println("not intercepted");
        return true;
    }

    @Override
    public void postHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

