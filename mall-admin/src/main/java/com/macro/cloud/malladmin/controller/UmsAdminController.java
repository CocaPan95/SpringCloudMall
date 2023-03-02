package com.macro.cloud.malladmin.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import com.macro.cloud.malladmin.domain.UserDTO;
import com.macro.cloud.malladmin.service.UmsAdminService;
import com.macro.cloud.mallcommon.api.CommonResult;
import com.macro.cloud.mallcommon.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;


    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        UserDto userDTO = adminService.loadUserByUsername(username);
        return userDTO;
    }


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userStr = request.getHeader("user");
        JSONObject userJsonObject = new JSONObject(userStr);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userJsonObject.getStr("user_name"));
        userDTO.setId(Convert.toLong(userJsonObject.get("id")));
        userDTO.setRoles(Convert.toList(String.class,userJsonObject.get("authorities")));
        return CommonResult.success(userDTO);
    }
}
