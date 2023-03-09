package com.macro.cloud.mallsearch.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.macro.cloud.mapper","com.macro.cloud.mallsearch.dao"})
public class MyBatisConfig {
}
