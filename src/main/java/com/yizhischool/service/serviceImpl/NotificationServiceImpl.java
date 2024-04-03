package com.yizhischool.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhischool.mapper.NotificationMapper;
import com.yizhischool.pojo.Entity.Notification;
import com.yizhischool.pojo.VO.NotificationVO;
import com.yizhischool.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements INotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public ArrayList<NotificationVO> notificationGet() {
        List<Notification> notifications= notificationMapper.selectList(new QueryWrapper<>());
        ArrayList<NotificationVO> notificationVOS = new ArrayList<>();
        for (Notification notification: notifications) {
            NotificationVO notificationVO = NotificationVO.builder().
                    time(notification.getTime()).
                    author(notification.getAuthor()).
                    content(notification.getContent()).
                    title(notification.getTitle()).
                    build();
            notificationVOS.add(notificationVO);
        }
        return notificationVOS;
    }
}
