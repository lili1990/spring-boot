package com.lili.transaction.jdbc.service.impl;

import com.lili.transaction.jdbc.models.User;
import com.lili.transaction.jdbc.service.UserService;
import com.lili.transaction.jdbc.service.base.AbstractBaseService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
