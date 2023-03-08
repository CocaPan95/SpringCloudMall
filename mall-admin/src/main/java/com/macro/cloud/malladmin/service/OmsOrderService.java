package com.macro.cloud.malladmin.service;

import com.macro.cloud.malladmin.dto.OmsOrderDeliveryParam;
import com.macro.cloud.malladmin.dto.OmsOrderQueryParam;
import com.macro.cloud.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理Service
 * Created by macro on 2018/10/11.
 */
public interface OmsOrderService {
    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);
}
