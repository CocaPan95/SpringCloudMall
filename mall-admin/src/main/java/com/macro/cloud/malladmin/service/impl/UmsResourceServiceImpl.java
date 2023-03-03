package com.macro.cloud.malladmin.service.impl;

import com.macro.cloud.malladmin.service.UmsResourceService;
import com.macro.cloud.mallcommon.constant.AuthConstant;
import com.macro.cloud.mallcommon.service.RedisService;
import com.macro.cloud.mapper.UmsResourceMapper;
import com.macro.cloud.mapper.UmsRoleMapper;
import com.macro.cloud.mapper.UmsRoleResourceRelationMapper;
import com.macro.cloud.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsResourceMapper resourceMapper;

    @Autowired
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public Map<String, List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        List<UmsResource> resourceList = resourceMapper.selectByExample(new UmsResourceExample());
        List<UmsRole> roleList = roleMapper.selectByExample(new UmsRoleExample());
        List<UmsRoleResourceRelation> relationList = roleResourceRelationMapper.selectByExample(new UmsRoleResourceRelationExample());
        for (UmsResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(UmsRoleResourceRelation::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put("/"+applicationName+resource.getUrl(),roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;

    }
}
