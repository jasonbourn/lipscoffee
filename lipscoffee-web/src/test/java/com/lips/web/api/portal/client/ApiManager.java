package com.lips.web.api.portal.client;

import org.forkjoin.apikit.client.HttpClientAdapter;

/**
 * api 管理器，单例，使用之前需要初始化
 * @author zuoge85 on 15/6/15.
 */
public class ApiManager {
    private static ApiManager instance;

   /**
    * 初始化
    */
    public static void init(HttpClientAdapter httpClientAdapter) {
        instance = new ApiManager(httpClientAdapter);
    }

    public static ApiManager getInstance() {
        return instance;
    }

    private HttpClientAdapter httpClientAdapter;

   /**
    * Created by qiang on 2017/4/24.
    */
    public final Test test;



    public ApiManager(HttpClientAdapter httpClientAdapter) {
        this.httpClientAdapter = httpClientAdapter;

        test =  new Test(httpClientAdapter);
    }
}
