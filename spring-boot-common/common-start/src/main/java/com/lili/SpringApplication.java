package com.lili;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * @author lili
 * @date 2019/1/2
 * @description 改启动类有XML配置文件
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring/*.xml"})
public class SpringApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}
