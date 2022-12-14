package com.example.wechatmessage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:wx
 * @Author:lxx
 * @Date 2022/11/6 16:33
 **/
@Configuration
@ConfigurationProperties(prefix = "wechat.mp")
@Data
public class WechatMpProperties {
    /**
     * 设置微信公众号的appid
     */
    private String appId;

    /**
     * 设置微信公众号的app secret
     */
    private String secret;

    /**
     * 设置微信公众号的token
     */
    private String token;

    /**
     * 设置微信公众号的EncodingAESKey
     */
    private String aesKey;
}
