package com.yizhischool.pojo.Entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("class_log")
public class ClassLog {

    @TableId(value = "id",type = IdType.AUTO)
    Long id;

    @TableField(value = "belong")
    String belong;

    @TableField(value = "content")
    String content;

    @TableField(value="time")
    String time;

    @TableField(value="author")
    String author;

    @TableField(value="title")
    String title;
}
