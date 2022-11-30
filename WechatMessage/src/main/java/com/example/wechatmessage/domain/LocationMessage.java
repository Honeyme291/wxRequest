package com.example.wechatmessage.domain;

/**
 * @ClassName:LocationMessage
 * @Author:lxx
 * @Date 2022/11/30 10:33
 **/
import lombok.Data;

/**
 * @author yh
 * @date 2020/8/21 10:15
 * @description: 地理位置消息
 */
@Data
public class LocationMessage extends BaseMs {
    // 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;
}

