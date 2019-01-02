package com.lili.transaction.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lili
 * @date 2019/1/2
 * @description
 */
@Configuration
@MapperScan("com.lili.transaction.mybatis.mapper")
public class MapperConfig {
}


