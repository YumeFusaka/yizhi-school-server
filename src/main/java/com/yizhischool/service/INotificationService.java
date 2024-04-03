package com.yizhischool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhischool.pojo.Entity.Notification;
import com.yizhischool.pojo.VO.NotificationVO;

import java.util.ArrayList;

public interface INotificationService extends IService<Notification> {
    ArrayList<NotificationVO> notificationGet();
}
