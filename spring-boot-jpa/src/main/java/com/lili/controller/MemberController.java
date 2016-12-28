package com.lili.controller;

import com.lili.models.Member;
import com.lili.repository.MemberRepositry;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/12/28.
 */
@RestController
@RequestMapping(value="/member")
public class MemberController {

    @Resource
    private MemberRepositry memberRepositry;

    @ApiOperation(value="创建用户", notes="")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Member createMember(@RequestBody Member member){
        memberRepositry.save(member);
        return member;
    }

    @ApiOperation(value="删除用户", notes="")
    @RequestMapping(value = "/delete/{memberId}",method = RequestMethod.DELETE)
    public String deleteMember(@PathVariable Long memberId){
        memberRepositry.delete(memberId);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据name来获取用户详细信息")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Member getMemberByName(@ApiParam(value = "用户名", required = false) @RequestParam String name){
        Member member =memberRepositry.findMember(name);
        return member;
    }
}
