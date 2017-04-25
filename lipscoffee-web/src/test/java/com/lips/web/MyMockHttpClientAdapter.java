package com.lips.web;

import org.forkjoin.apikit.client.Callback;
import org.forkjoin.apikit.core.Result;
import org.forkjoin.apikit.spring.client.MockHttpClientAdapter;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author zuoge85@gmail.com on 2017/3/31.
 */
public class MyMockHttpClientAdapter extends MockHttpClientAdapter {
    public MyMockHttpClientAdapter(String serverUrl) {
        super(serverUrl);
    }

    @Override
    public <T> Result<T> request(String method, String uri, List<Map.Entry<String, Object>> form, Type type, boolean isAccount) {
        return super.request(method, uri + ".json", form, type, isAccount);
    }

    @Override
    public <T> Future<?> requestAsync(final String method, final String uri, final List<Map.Entry<String, Object>> form, final Type type, final boolean isAccount, final Callback<T> callable) {
        return super.requestAsync(method, uri + ".json", form, type, isAccount, callable);
    }
}
