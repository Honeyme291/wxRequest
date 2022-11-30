package com.example.wechatmessage.domain;

/**
 * @ClassName:VideoMessage
 * @Author:lxx
 * @Date 2022/11/30 10:34
 **/
import lombok.Data;

/**
 * @author yh
 * @date 2020/8/21 10:16
 * @description:  视频/小视频消息
 */
@Data
public class VideoMessage extends BaseMs{

    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;

}
