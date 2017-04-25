package com.lips.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {
    /**
     * 添加拦截器
     **/
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SpringInterceptor());
    }


}
