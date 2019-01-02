package com.lili.transaction.jpa.models;

import javax.persistence.Entity;

/**
 * Created by lili19289 on 2016/12/27.
 */
@Entity
public class Member extends BaseModel {

    public String username;
    public String password;

    public String email;
    public String fullName;

    /**
     * 头像路径
     */
    public String avatarUrl;

    /**
     * 手机号码
     */
    public String phone;
    /**
     * 最后登录ip地址
     */
    public String lastLoginIp;

    /**
     * 登录次数
     */
    public Long loginCount = 0l;

    public long lastLoginTime = System.currentTimeMillis();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Long loginCount) {
        this.loginCount = loginCount;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
