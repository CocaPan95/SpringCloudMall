package com.macro.cloud.malladmin.service.impl;

import com.macro.cloud.malladmin.dao.UmsAdminRoleRelationDao;
import com.macro.cloud.malladmin.dao.UmsRoleDao;
import com.macro.cloud.malladmin.service.UmsRoleService;
import com.macro.cloud.model.UmsMenu;
import com.macro.cloud.model.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Autowired
    private UmsRoleDao roleDao;
    /**
     * 获取用户对于角色
     */
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }
}
