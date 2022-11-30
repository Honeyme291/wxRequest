package com.example.wechatmessage.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:api
 * @Author:lxx
 * @Date 2022/11/30 9:50
 **/
public interface api{
    @GetMapping("/wxRequest")
    String doGet(HttpServletRequest request, HttpServletResponse response);

    /**
     * @author: lxx
     * @description: 消息的接收和处理
     * @date:
     * @param request
     * @param response
     * @return void
     **/
    @PostMapping("/wxRequest")
    void doPost(HttpServletRequest request, HttpServletResponse response);
}

