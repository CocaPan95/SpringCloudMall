package com.macro.cloud.mallportal.controller;

import com.macro.cloud.mallcommon.api.CommonResult;
import com.macro.cloud.mallcommon.domain.UserDto;
import com.macro.cloud.mallportal.service.UmsMemberService;
import com.macro.cloud.model.UmsMember;
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
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info() {
        UmsMember member = memberService.getCurrentMember();
        return CommonResult.success(member);
    }

    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        return memberService.loadUserByUsername(username);
    }
}
