package com.macro.cloud.malladmin.service;

import com.macro.cloud.mallcommon.domain.UserDto;
import com.macro.cloud.model.UmsAdmin;
import com.macro.cloud.model.UmsRole;

import java.util.List;

public interface UmsAdminService {
    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 获取当前登录后台用户
     */
    UmsAdmin getCurrentAdmin();

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);
}
