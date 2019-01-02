package com.lili.transaction.mybatis.service.impl;


import com.lili.transaction.mybatis.service.UserService;
import com.lili.transaction.mybatis.mapper.UserMapper;
import com.lili.transaction.mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void create(String name, Integer age){
        userMapper.insert(name,age);
    }
    @Override
    public void deleteByName(String name){

    }
    @Override
    public User findByName(String name){
        return userMapper.findByName(name);
    }


}
