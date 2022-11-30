package com.example.wechatmessage.domain;

import lombok.Data;

/**
 * @ClassName:BaseMs
 * @Author:lxx
 * @Date 2022/11/30 9:38
 **/
@Data
public class BaseMs {

        private String ToUserName;
        private String FromUserName;
        private long CreateTime;
        private String MsgType;
        private long MsgId;
        //省略 getter/settest

}
