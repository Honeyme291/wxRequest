package com.example.wechatmessage.controller;

import com.example.wechatmessage.config.EventDispatcher;
import com.example.wechatmessage.config.MsgDispatcher;
import com.example.wechatmessage.controller.api.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.wechatmessage.Util.MsUtil;

import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName:ApiController
 * @Author:lxx
 * @Date 2022/11/30 9:52
 **/
@Slf4j
@AllArgsConstructor
@RestController
public class ApiController implements api {
    private final WxMpService wxService;

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.info("signature[{}], timestamp[{}], nonce[{}], echostr[{}]", signature, timestamp, nonce, echostr);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }
        return "";
    }

    /**
     * @param request
     * @param response
     * @return void
     * @author: yh
     * @description: 消息/事件的接收和处理
     * @date: 2020/8/21
     **/
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String> messageMap = MsUtil.parseXml(request);
            System.out.println("消息：" + messageMap.get("Content"));
            String type = messageMap.get("MsgType");
            if (MsUtil.REQ_MESSAGE_TYPE_EVENT.equals(type)) {
                //事件处理
                EventDispatcher.processEvent(messageMap);
            } else {
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                //消息处理
                String data = MsgDispatcher.processMessage(messageMap);
                PrintWriter out = response.getWriter();
                out.print(data);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
