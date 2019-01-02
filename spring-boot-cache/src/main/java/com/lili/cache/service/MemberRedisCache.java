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
public class MemberRedisCache {

    private Logger LOGGER = LoggerFactory.getLogger(MemberRedisCache.class);

    @Autowired
    private MemberRepositry memberRepositry;

    public static final String  CACHE_NAME  = "MemberRedisCache";


    @Cacheable(value = CACHE_NAME, key = "#p0", unless = "#result == null",cacheManager = "redisCacheManager")
    public Member getMermber(Long memberId){
        LOGGER.info("-----------------get member from redis------------");
        return memberRepositry.getOne(memberId);
    }

}
