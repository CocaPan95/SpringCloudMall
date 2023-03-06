package com.macro.cloud.mallportal.service;

import com.macro.cloud.mallportal.domain.PmsProductCategoryNode;

import java.util.List;

public interface PmsPortalProductService {
    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();
}
