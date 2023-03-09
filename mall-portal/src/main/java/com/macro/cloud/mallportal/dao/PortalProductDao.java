package com.macro.cloud.mallportal.dao;

import com.macro.cloud.mallportal.domain.CartProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 * Created by macro on 2018/8/2.
 */
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);
//    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
//    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId,@Param("productCategoryId")Long productCategoryId);
}
