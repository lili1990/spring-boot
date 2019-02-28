package com.lili.cache.service;

import com.lili.cache.models.Member;
import com.lili.cache.repository.MemberRepositry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author lili
 * @date 2019/1/2
 * @description
 */
@Component
public class MemberLocalCache {

    private Logger LOGGER = LoggerFactory.getLogger(MemberLocalCache.class);


    @Autowired
    private MemberRedisCache memberRedisCache;



    private static final String  CACHE_NAME  = "MemberLocalCache";

    private static final Object NULL_OBJRCT = new Object();



    /**
     * 防止缓存击穿,null值也要存储
     * @param memberId
     * @return
     */
    @Cacheable(value = CACHE_NAME, key = "#p0",cacheManager = "ehCacheManager")
    public Member getMermber(Long memberId){
        LOGGER.info("-------------------get member from ehcache-----------------");
        Member member =  memberRedisCache.getMermber(memberId);
        if(member == null){
            return (Member) NULL_OBJRCT;
        }
        return member;
    }

}
