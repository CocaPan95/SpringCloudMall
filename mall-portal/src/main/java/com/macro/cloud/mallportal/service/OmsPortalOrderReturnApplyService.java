package com.macro.cloud.mallportal.service;

import com.macro.cloud.mallportal.domain.OmsOrderReturnApplyParam;

public interface OmsPortalOrderReturnApplyService {
    /**
     * 提交申请
     */
    int create(OmsOrderReturnApplyParam returnApply);
}
