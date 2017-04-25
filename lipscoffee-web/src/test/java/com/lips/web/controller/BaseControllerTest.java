package com.lips.web.controller;

import com.lips.web.LipsCoffeeApplication;
import com.lips.web.api.portal.client.ApiManager;
import org.forkjoin.apikit.spring.client.AbstractHttpClientAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LipsCoffeeApplication.class)
@ComponentScan
public class BaseControllerTest {

    @Autowired
    protected ApiManager apiManager;

    @Autowired
    protected AbstractHttpClientAdapter httpClientAdapter;

    @Test
    public void testDate() throws Exception {
        System.out.println(apiManager.test.home());
    }
}