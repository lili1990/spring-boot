package com.lili.controller;


import com.lili.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.lili.models.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/12/23.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Resource
    private UserService userService;



    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        userService.create(user.getName(),user.getAge());
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的name来获取用户详细信息")
    @RequestMapping(value="/info", method=RequestMethod.GET)
    public User getUser(@ApiParam(value = "用户名", required = false) @RequestParam String name ) {
        return userService.findByName(name);
    }




    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteByName("lil");
        return "success";
    }

}
