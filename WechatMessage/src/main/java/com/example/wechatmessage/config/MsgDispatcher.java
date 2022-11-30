package com.example.wechatmessage.config;

import com.alibaba.fastjson.JSONObject;
import com.example.wechatmessage.Util.MsUtil;
import com.example.wechatmessage.domain.*;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName:MsgDispatcher
 * @Author:lxx
 * @Date 2022/11/30 10:09
 **/
public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) {
        String openid = map.get("FromUserName"); //用户openid
        String mpid = map.get("ToUserName");   //公众号原始ID
        TextMs textMessageRes = new TextMs();
        textMessageRes.setToUserName(openid);
        textMessageRes.setFromUserName(mpid);
        textMessageRes.setCreateTime(new Date().getTime());
        textMessageRes.setMsgType(MsUtil.RESP_MESSAGE_TYPE_TEXT);

        if (map.get("MsgType").equals(MsUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            System.out.println("==============这是文本消息！");
            String jsonString = JSONObject.toJSONString(map);
            TextMs textMessage = JSONObject.parseObject(jsonString, TextMs.class);

            textMessageRes.setContent("你好，这里是测试回复");

            return MsUtil.textMessageToXml(textMessageRes);
        }
        if (map.get("MsgType").equals(MsUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
            String jsonString = JSONObject.toJSONString(map);
            ImageMessage imageMessage = JSONObject.parseObject(jsonString, ImageMessage.class);
            textMessageRes.setContent("你好，这里是测试回复");

        }


        if (map.get("MsgType").equals(MsUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
            String jsonString = JSONObject.toJSONString(map);
            LinkMessage linkMessage = JSONObject.parseObject(jsonString, LinkMessage.class);
            textMessageRes.setContent("你好，这里是测试回复");

        }


        if (map.get("MsgType").equals(MsUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
            String jsonString = JSONObject.toJSONString(map);
            LocationMessage locationMessage = JSONObject.parseObject(jsonString, LocationMessage.class);
            textMessageRes.setContent("你好，这里是测试回复");

        }


        if (map.get("MsgType").equals(MsUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频/小视频消息
            System.out.println("==============这是视频消息！");
            String jsonString = JSONObject.toJSONString(map);
            VideoMessage videoMessage = JSONObject.parseObject(jsonString, VideoMessage.class);
            textMessageRes.setContent("你好，这里是测试回复");

        }

        if (map.get("MsgType").equals(MsUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
            String jsonString = JSONObject.toJSONString(map);
            VoiceMessage voiceMessage = JSONObject.parseObject(jsonString, VoiceMessage.class);
            textMessageRes.setContent("你好，这里是测试回复");

        }
        return "";
    }
}
