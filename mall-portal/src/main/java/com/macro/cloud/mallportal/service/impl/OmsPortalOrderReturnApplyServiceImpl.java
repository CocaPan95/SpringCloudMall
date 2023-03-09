package com.macro.cloud.mallportal.service.impl;

import com.macro.cloud.mallportal.domain.OmsOrderReturnApplyParam;
import com.macro.cloud.mallportal.service.OmsPortalOrderReturnApplyService;
import com.macro.cloud.mapper.OmsOrderReturnApplyMapper;
import com.macro.cloud.model.OmsOrderReturnApply;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyMapper returnApplyMapper;
    @Override
    public int create(OmsOrderReturnApplyParam returnApply) {
        OmsOrderReturnApply realApply = new OmsOrderReturnApply();
        BeanUtils.copyProperties(returnApply,realApply);
        realApply.setCreateTime(new Date());
        realApply.setStatus(0);
        return returnApplyMapper.insert(realApply);
    }
}
