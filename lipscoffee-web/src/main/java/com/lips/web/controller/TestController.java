package com.lips.web.controller;

import com.github.pagehelper.PageInfo;
import com.lips.dao.lipsAdmin.pojo.SysUser;
import com.lips.web.service.TestService;
import org.forkjoin.apikit.core.Api;
import org.forkjoin.apikit.core.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by qiang on 2017/4/24.
 */
@Api
@RestController
public class TestController {
    @Resource
    private TestService testService;
    @RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
    Result<List<SysUser>> home() {

        return Result.createSuccess(testService.selectAll());
    }

    @RequestMapping(value = "/testDate",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Result<String> test(Date date) {
        return Result.createSuccess(date.toString());
    }


    @RequestMapping(value = "/pageTest",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Result<PageInfo<SysUser>> pageTest() {
        return Result.createSuccess(testService.pageTest());
    }
}
