package com.lili.service.impl;


import com.lili.service.UserService;
import com.lili.mapper.UserMapper;
import com.lili.models.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl  implements UserService {

    @Resource
    private UserMapper userMapper;


    public void create(String name, Integer age){
        userMapper.insert(name,age);
    }

    public void deleteByName(String name){

    }

    public User findByName(String name){
        return userMapper.findByName(name);
    }


}
