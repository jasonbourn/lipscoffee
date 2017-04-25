package com.lips.web;

import com.lips.web.api.portal.client.ApiManager;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Bean;

/**
 * Created by qiang on 2017/4/25.
 */
@TestComponent
public class BeanConfig {
    @Bean(name = "httpClientAdapter")
    private MyMockHttpClientAdapter myMockHttpClientAdapter(){
        MyMockHttpClientAdapter myMockHttpClientAdapter =new MyMockHttpClientAdapter("http://localhost:8080/");
        return  myMockHttpClientAdapter;
    }

    @Bean(name = "apiManager")
    public ApiManager apiManager(MyMockHttpClientAdapter myMockHttpClientAdapter){
        ApiManager.init(myMockHttpClientAdapter);
        ApiManager apiManager =ApiManager.getInstance();
        return apiManager;
    }

}
