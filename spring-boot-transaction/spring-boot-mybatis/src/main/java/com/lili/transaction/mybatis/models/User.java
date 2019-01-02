package com.lili.transaction.mybatis.models;

/**
 * Created by lili19289 on 2016/12/23.
 */
public class User extends BaseModel{
    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
