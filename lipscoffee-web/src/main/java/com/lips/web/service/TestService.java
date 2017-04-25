package com.lips.web.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lips.dao.lipsAdmin.SysUserMapper;
import com.lips.dao.lipsAdmin.pojo.SysUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiang on 2017/4/24.
 */
@Service
public class TestService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private RedisTemplate<String,List<SysUser>> redisTemplate;

    public List<SysUser> selectAll(){
        if (redisTemplate.opsForValue().get("testKey")==null){
            redisTemplate.opsForValue().set("testKey",sysUserMapper.selectAll());
            System.out.println("redis数据初始化");
            return sysUserMapper.selectAll();
        }else {
            return redisTemplate.opsForValue().get("testKey");
        }

    }

    public PageInfo<SysUser> pageTest() {
        try {
            PageHelper.startPage(1,4,true);
            List<SysUser> pagelist = sysUserMapper.selectAll();
            PageInfo<SysUser> list =new PageInfo<>(pagelist);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
