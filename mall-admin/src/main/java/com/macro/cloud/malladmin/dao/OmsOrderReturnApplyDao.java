package com.macro.cloud.malladmin.dao;

import com.macro.cloud.malladmin.dto.OmsOrderReturnApplyResult;
import com.macro.cloud.malladmin.dto.OmsReturnApplyQueryParam;
import com.macro.cloud.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * Created by macro on 2018/10/18.
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}

