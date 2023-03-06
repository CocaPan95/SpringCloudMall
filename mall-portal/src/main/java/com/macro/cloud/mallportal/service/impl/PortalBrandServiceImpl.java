package com.macro.cloud.mallportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.cloud.mallcommon.api.CommonPage;
import com.macro.cloud.mallportal.service.PortalBrandService;
import com.macro.cloud.mapper.PmsBrandMapper;
import com.macro.cloud.mapper.PmsProductMapper;
import com.macro.cloud.model.PmsBrand;
import com.macro.cloud.model.PmsProduct;
import com.macro.cloud.model.PmsProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalBrandServiceImpl implements PortalBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public PmsBrand detail(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andBrandIdEqualTo(brandId);
        List<PmsProduct> productList = productMapper.selectByExample(example);
        return CommonPage.restPage(productList);
    }
}
