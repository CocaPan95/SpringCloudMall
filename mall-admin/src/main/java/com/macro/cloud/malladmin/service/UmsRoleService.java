package com.macro.cloud.malladmin.service;

import com.macro.cloud.model.UmsMenu;
import com.macro.cloud.model.UmsResource;
import com.macro.cloud.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsRoleService {

    /**
     * 添加角色
     */
    int create(UmsRole role);

    /**
     * 修改角色信息
     */
    int update(Long id, UmsRole role);

    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 批量删除角色
     */
    int delete(List<Long> ids);

    /**
     * 获取所有角色列表
     */
    List<UmsRole> list();

    /**
     * 分页获取角色列表
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);
    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
