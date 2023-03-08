package com.macro.cloud.mallportal.service;

import com.macro.cloud.mallportal.domain.PmsPortalProductDetail;
import com.macro.cloud.mallportal.domain.PmsProductCategoryNode;
import com.macro.cloud.model.PmsProduct;

import java.util.List;

public interface PmsPortalProductService {
    /**
     * 综合搜索商品
     */
    List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

    /**
     * 以树形结构获取所有商品分类
     */
    List<PmsProductCategoryNode> categoryTreeList();

    /**
     * 获取前台商品详情
     */
    PmsPortalProductDetail detail(Long id);
}
