package com.macro.cloud.mallauth.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Oauth2获取Token返回信息封装
 * Created by macro on 2020/7/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenDto {
    /**
     * 访问令牌
     */
    @ApiModelProperty("访问令牌")
    private String token;
    /**
     * 刷新令牌
     */
    @ApiModelProperty("刷令牌")
    private String refreshToken;
    /**
     * 访问令牌头前缀
     */
    @ApiModelProperty("访问令牌头前缀")
    private String tokenHead;
    /**
     * 有效时间（秒）
     */
    @ApiModelProperty("有效时间（秒）")
    private int expiresIn;
}
