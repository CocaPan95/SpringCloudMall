package com.macro.cloud.malladmin.config;

import com.macro.cloud.mallcommon.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis相关配置
 * Created by macro on 2020/6/19.
 */
@Configuration
@EnableCaching
public class RedisConfig extends BaseRedisConfig {

}

