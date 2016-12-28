package com.lili.service;


import com.lili.models.User;

/**
 * Created by lili19289 on 2016/12/26.
 */
public interface UserService {


    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);
    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    User findByName(String name);

}
