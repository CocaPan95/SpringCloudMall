package com.macro.cloud.malladmin.controller;

import com.macro.cloud.mallcommon.api.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/GetUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> GetUserInfo(){
        return CommonResult.success("获取到了用户a");
    }
}
