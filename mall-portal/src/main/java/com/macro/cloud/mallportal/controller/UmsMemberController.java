package com.macro.cloud.mallportal.controller;

import com.macro.cloud.mallcommon.api.CommonResult;
import com.macro.cloud.mallcommon.domain.UserDto;
import com.macro.cloud.mallportal.service.UmsMemberService;
import com.macro.cloud.model.UmsMember;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation("会员注册")
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode){

        memberService.register(username, password, telephone, authCode);
        return CommonResult.success(null,"注册成功");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation("会员登录")
    @ResponseBody
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password){
        return memberService.login(username, password);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation("获取会员信息")
    @ResponseBody
    public CommonResult info() {
        UmsMember member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ApiOperation("修改密码")
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String password,
                                       @RequestParam String authCode) {
        memberService.updatePassword(telephone,password,authCode);
        return CommonResult.success(null,"密码修改成功");
    }
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ApiOperation("获取验证码")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode,"获取验证码成功");
    }

    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ApiOperation("根据用户名获取通用用户信息")
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        return memberService.loadUserByUsername(username);
    }
}
