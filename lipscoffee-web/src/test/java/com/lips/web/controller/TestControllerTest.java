package com.lips.web.controller;

import org.junit.Test;

/**
 * Created by qiang on 2017/4/24.
 */

public class TestControllerTest extends BaseControllerTest {

    @Test
    public void testDate() throws Exception {
        System.out.println(apiManager.test.home());
    }
    @Test
    public void page() throws Exception {
        System.out.println(apiManager.test.pageTest());
    }
}
