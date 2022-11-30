package com.example.wechatmessage.config;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:op
 * @Author:lxx
 * @Date 2022/11/6 16:39
 **/
@AllArgsConstructor
@Configuration
public class WxMpConfiguration {

    @Autowired
    private WechatMpProperties properties;

    @Bean
    public WxMpService wxMpService() {
        WxMpService service = new WxMpServiceImpl();
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(properties.getAppId());
        configStorage.setSecret(properties.getSecret());
        configStorage.setToken(properties.getToken());
        configStorage.setAesKey(properties.getAesKey());
        Map<String, WxMpConfigStorage> storageMap = new HashMap<>();
        storageMap.put(properties.getAppId(), configStorage);
        service.setMultiConfigStorages(storageMap);
        return service;
    }

}
