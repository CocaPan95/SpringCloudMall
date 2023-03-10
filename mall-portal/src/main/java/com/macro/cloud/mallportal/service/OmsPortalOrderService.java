package com.macro.cloud.mallportal.service;

import com.macro.cloud.mallcommon.api.CommonPage;
import com.macro.cloud.mallportal.domain.ConfirmOrderResult;
import com.macro.cloud.mallportal.domain.OmsOrderDetail;
import com.macro.cloud.mallportal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OmsPortalOrderService {

    /**
     * 根据用户购物车信息生成确认单信息
     * @param cartIds
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    Integer paySuccess(Long orderId, Integer payType);
    /**
     * 分页获取用户订单
     */
    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据订单ID获取订单详情
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();
    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 确认收货
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * 用户根据订单ID删除订单
     */
    void deleteOrder(Long orderId);
}
