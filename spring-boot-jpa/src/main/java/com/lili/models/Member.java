package com.lili.models;

import javax.persistence.Entity;

/**
 * Created by lili19289 on 2016/12/27.
 */
@Entity
public class Member extends BaseModel {

    public String username;
    public String password;

    public String email;
    public String fullName; //

    public String avatarUrl; // 头像路径 add


    public String phone; // 手机号码

    public String lastLoginIp; // 最后登录ip地址

    public Long loginCount = 0l; // 登录次数

    public long lastLoginTime = System.currentTimeMillis();


}
