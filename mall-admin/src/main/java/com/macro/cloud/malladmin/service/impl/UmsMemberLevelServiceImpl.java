package com.macro.cloud.malladmin.service.impl;

import com.macro.cloud.malladmin.service.UmsMemberLevelService;
import com.macro.cloud.mapper.UmsMemberLevelMapper;
import com.macro.cloud.model.UmsMemberLevel;
import com.macro.cloud.model.UmsMemberLevelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {

    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
