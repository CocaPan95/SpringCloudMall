package com.macro.cloud.malladmin.dao;

import com.macro.cloud.model.UmsMenu;
import com.macro.cloud.model.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsRoleDao {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);
}
