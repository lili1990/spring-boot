package com.lili.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.lili.models.User;
import com.lili.service.UserService;
import com.lili.service.base.AbstractBaseService;
import com.lili.service.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lili19289 on 2016/12/26.
 */
@Service
public class UserServiceImpl extends AbstractBaseService implements UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public User get(long userId) {
        return (User) find("select * from user where id = ?",User.class,userId);

    }

    @Override
    public List<User> fetchUsers(Integer page, Integer pageSize){
        int start=0,end=0;
        if(page!=null && page >=1){
            start=(page-1)*pageSize;
            end=page*pageSize;
        }
        return  fetch("select * from user limit ?,?",User.class,start,end);
    }

    @Override
    public void create(String name, Integer age) {
        save("insert into user(user_name, age,password) values(?, ?,?)", name, age,"111111");
    }
    @Override
    public void deleteByName(String name) {
        delete("delete from USER where NAME = ?", name);
    }
    @Override
    public Integer getAllUsers() {
        return count("select count(1) from USER", Integer.class);
    }
    @Override
    public void deleteAllUsers() {
        delete("delete from USER");
    }
}
