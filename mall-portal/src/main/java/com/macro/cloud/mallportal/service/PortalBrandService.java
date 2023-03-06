package com.macro.cloud.mallportal.service;

import com.macro.cloud.mallcommon.api.CommonPage;
import com.macro.cloud.model.PmsBrand;
import com.macro.cloud.model.PmsProduct;

/**
 * 前台品牌管理Service
 * Created by macro on 2020/5/15.
 */
public interface PortalBrandService {
    /**
     * 获取品牌详情
     */
    PmsBrand detail(Long brandId);

    /**
     * 分页获取品牌关联商品
     */
    CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);
}
