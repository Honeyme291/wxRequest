package com.example.wechatmessage.domain;

/**
 * @ClassName:VoidMessage
 * @Author:lxx
 * @Date 2022/11/30 10:34
 **/
import lombok.Data;

/**
 * @author yh
 * @date 2020/8/21 10:17
 * @description: 语音消息
 */
@Data
public class VoiceMessage extends BaseMs {
    // 语音消息媒体id，可以调用获取临时素材+接口拉取数据。
    private String MediaId;
    // 语音格式
    private String Format;
}

