//package com.leetcode2024spring.ecommercedemo1.config;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//public class MyInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 读取Authorization头部信息
//        String authorizationHeader = request.getHeader("Authorization");
//        if (authorizationHeader != null) {
//            // 处理Authorization头部信息
//            System.out.println("Authorization Header: " + authorizationHeader);
//        } else {
//            // Authorization头部信息不存在
//            System.out.println("Authorization Header not found");
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // 在处理程序执行之后调用
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // 在请求完成之后调用，包括渲染视图之后
//    }
//}
//
