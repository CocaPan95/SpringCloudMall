package com.macro.cloud.malladmin.service.impl;

import com.macro.cloud.malladmin.service.OmsCompanyAddressService;
import com.macro.cloud.mapper.OmsCompanyAddressMapper;
import com.macro.cloud.model.OmsCompanyAddress;
import com.macro.cloud.model.OmsCompanyAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by macro on 2018/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
