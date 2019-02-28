package com.lili.cache.controller;

import com.lili.cache.models.Member;
import com.lili.cache.repository.MemberRepositry;
import com.lili.cache.service.MemberLocalCache;
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

    @Resource
    private MemberLocalCache memberLocalCache;

    @ApiOperation(value="创建用户", notes="")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Member createMember(@RequestBody Member member){
        memberRepositry.save(member);
        return member;
    }

    @ApiOperation(value="删除用户", notes="")
    @RequestMapping(value = "/delete/{memberId}",method = RequestMethod.DELETE)
    public String deleteMember(@PathVariable Long memberId){
        memberRepositry.deleteById(memberId);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据ID来获取用户详细信息")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Member getMemberByName(@ApiParam(value = "用户ID", required = false) @RequestParam Long memberId){
        Member member =memberLocalCache.getMermber(memberId);
//        Member member= memberRepositry.getOne(memberId);
        return member ;
    }
}
