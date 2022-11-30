package com.example.wechatmessage.domain;

/**
 * @ClassName:ImageMessage
 * @Author:lxx
 * @Date 2022/11/30 10:33
 **/
import lombok.Data;

/**
 * @author yh
 * @date 2020/8/21 10:14
 * @description: 图片消息
 */
@Data
public class ImageMessage extends BaseMs {
    // 图片链接
    private String PicUrl;
    //图片消息媒体id，可以调用获取临时素材接口拉取数据。
    private String MediaId;
}

