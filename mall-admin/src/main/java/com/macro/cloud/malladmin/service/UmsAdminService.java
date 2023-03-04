package com.macro.cloud.malladmin.service;

import com.macro.cloud.malladmin.dto.UmsAdminParam;
import com.macro.cloud.malladmin.dto.UpdateAdminPasswordParam;
import com.macro.cloud.mallcommon.api.CommonResult;
import com.macro.cloud.mallcommon.domain.UserDto;
import com.macro.cloud.model.UmsAdmin;
import com.macro.cloud.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsAdminService {
    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    CommonResult login(String username, String password);
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

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);


    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 删除指定用户
     */
    int delete(Long id);

    /**
     * 获取缓存服务
     */
    UmsAdminCacheService getCacheService();
}
