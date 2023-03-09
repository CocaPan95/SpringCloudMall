package com.macro.cloud.mallportal.service;

import com.macro.cloud.mallcommon.api.CommonResult;
import com.macro.cloud.mallcommon.domain.UserDto;
import com.macro.cloud.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {

    /**
     * 用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);
    /**
     * 登录后获取token
     */
    CommonResult login(String username, String password);
    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);
    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();


    /**
     * 修改密码
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);
    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);
    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);
}
