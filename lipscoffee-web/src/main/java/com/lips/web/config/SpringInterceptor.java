package com.lips.web.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(SpringInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 默认签名
        }
        response.setHeader("Cache-Control", "no-cache,no-store");
        response.setIntHeader("Expires", -1);
        response.setHeader("Pragma", "no-cache");
        return super.preHandle(request, response, handler);
    }
}
