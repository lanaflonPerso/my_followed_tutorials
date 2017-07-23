package com.wefine.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wefine.mybatis.mapper")
public class MybatisConfiguration {
}
