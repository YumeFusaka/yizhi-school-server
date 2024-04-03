package com.yizhischool.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notification")
public class Notification {

    @TableId(value = "id",type = IdType.AUTO)
    Long id;


    @TableField(value = "content")
    String content;

    @TableField(value = "author")
    String author;

    @TableField(value = "time")
    String time;

    @TableField(value = "title")
    String title;

}
