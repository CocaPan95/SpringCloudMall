package com.macro.cloud.mallportal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.util.StringUtil;
import com.macro.cloud.mallcommon.api.CommonResult;
import com.macro.cloud.mallcommon.api.ResultCode;
import com.macro.cloud.mallcommon.constant.AuthConstant;
import com.macro.cloud.mallcommon.domain.UserDto;
import com.macro.cloud.mallcommon.exception.Asserts;
import com.macro.cloud.mallportal.service.AuthService;
import com.macro.cloud.mallportal.service.UmsMemberCacheService;
import com.macro.cloud.mallportal.service.UmsMemberService;
import com.macro.cloud.mapper.UmsMemberLevelMapper;
import com.macro.cloud.mapper.UmsMemberMapper;
import com.macro.cloud.model.UmsMember;
import com.macro.cloud.model.UmsMemberExample;
import com.macro.cloud.model.UmsMemberLevel;
import com.macro.cloud.model.UmsMemberLevelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper memberMapper;

    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UmsMemberCacheService memberCacheService;

    @Override
    public void register(String username, String password, String telephone, String authCode) {
        //验证码检验
        if (!verifyAuthCode(authCode, telephone)) {
            Asserts.fail("验证码错误");
        }
        //查询是否有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo((telephone)));
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            Asserts.fail("该用户已经存在");
        }
        //没有用户则进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(BCrypt.hashpw(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        //设置默认的会员等级
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelExampleList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelExampleList)) {
            umsMember.setMemberLevelId(memberLevelExampleList.get(0).getId());
        }
        memberMapper.insert(umsMember);
        umsMember.setPassword(null);
    }

    @Autowired
    private AuthService authService;

    public CommonResult login(String username, String password) {
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.PORTAL_CLIENT_ID);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", username);
        params.put("password", password);
        return authService.getAccessToken(params);
    }

    @Override
    public UmsMember getCurrentMember() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if (StrUtil.isEmpty(userStr)) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UmsMember member = getById(userDto.getId());
        return member;
    }

    /**
     * 生成验证码
     */
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        memberCacheService.setAuthCode(telephone, sb.toString());
        return sb.toString();
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public UmsMember getByUsername(String username) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    public void updatePassword(String telephone, String password, String authCode){
        if(!verifyAuthCode(authCode,telephone)){
            Asserts.fail("验证码错误！");
        }
        UmsMemberExample umsMemberExample=new UmsMemberExample();
        umsMemberExample.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> umsMemberList=memberMapper.selectByExample(umsMemberExample);
        if(CollectionUtils.isEmpty(umsMemberList)){
            Asserts.fail("账号不存在");
        }
        UmsMember umsMember = umsMemberList.get(0);
        umsMember.setPassword(BCrypt.hashpw(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        memberCacheService.delMember(umsMember.getId());
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        UmsMember member = getByUsername(username);
        if (member != null) {
            UserDto userDto = new UserDto();
            BeanUtil.copyProperties(member, userDto);
            userDto.setRoles(CollUtil.toList("前台会员"));
            return userDto;
        }
        return null;
    }
    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
        memberCacheService.delMember(id);
    }
    private boolean verifyAuthCode(String authCode, String telephone) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }
}
