package com.macro.cloud.malladmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.cloud.malladmin.dao.OmsOrderDao;
import com.macro.cloud.malladmin.dao.OmsOrderOperateHistoryDao;
import com.macro.cloud.malladmin.dto.OmsOrderDeliveryParam;
import com.macro.cloud.malladmin.dto.OmsOrderQueryParam;
import com.macro.cloud.malladmin.service.OmsOrderService;
import com.macro.cloud.model.OmsOrder;
import com.macro.cloud.model.OmsOrderOperateHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderDao orderDao;

    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = orderDao.delivery(deliveryParamList);
        //添加操作记录
        List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(operateHistoryList);
        return count;
    }
}
