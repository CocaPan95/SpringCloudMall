//package com.macro.cloud.malladmin.service.impl;
//
//import com.macro.cloud.malladmin.service.UmsAdminCacheService;
//import com.macro.cloud.malladmin.service.UmsAdminService;
//import com.macro.cloud.mallcommon.service.RedisService;
//import com.macro.cloud.model.UmsAdmin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
///**
// * UmsAdminCacheService实现类
// * Created by macro on 2020/3/13.
// */
//@Service
//public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
//    @Autowired
//    private RedisService redisService;
//    @Value("${redis.database}")
//    private String REDIS_DATABASE;
//    @Value("${redis.expire.common}")
//    private Long REDIS_EXPIRE;
//    @Value("${redis.key.admin}")
//    private String REDIS_KEY_ADMIN;
//
//    @Override
//    public void delAdmin(Long adminId) {
//        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
//        redisService.del(key);
//    }
//
//    @Override
//    public UmsAdmin getAdmin(Long adminId) {
//        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + adminId;
//        return (UmsAdmin) redisService.get(key);
//    }
//
//    @Override
//    public void setAdmin(UmsAdmin admin) {
//        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getId();
//        redisService.set(key, admin, REDIS_EXPIRE);
//    }
//}
