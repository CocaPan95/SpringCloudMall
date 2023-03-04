package com.macro.cloud.malladmin.service;

import com.macro.cloud.model.UmsMenu;
import com.macro.cloud.model.UmsRole;

import java.util.List;

public interface UmsRoleService {
    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);
}
