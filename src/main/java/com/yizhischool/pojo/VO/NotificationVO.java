package com.yizhischool.pojo.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationVO {

    String content;

    String time;

    String author;

    String title;
}
