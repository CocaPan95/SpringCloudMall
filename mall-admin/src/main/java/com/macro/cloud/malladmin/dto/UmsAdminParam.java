package com.macro.cloud.malladmin.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminParam {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String icon;

    @Email
    private String email;

    private String nickName;

    private String note;
}
