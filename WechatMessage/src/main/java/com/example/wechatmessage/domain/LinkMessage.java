package com.example.wechatmessage.domain;

/**
 * @ClassName:LinkMessage
 * @Author:lxx
 * @Date 2022/11/30 10:32
 **/
import lombok.Data;

/**
 * @author yh
 * @date 2020/8/21 10:14
 * @description: 链接消息
 */
@Data
public class LinkMessage extends BaseMs{
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;
}

