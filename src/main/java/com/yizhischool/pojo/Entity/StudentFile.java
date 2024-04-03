package com.yizhischool.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Service;

@TableName("file")
@Data
public class StudentFile {

    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    @TableField("student_id")
    String student_id;

    @TableField("belong")
    String belong;

    @TableField("rap")
    Integer rap;

    @TableField("time")
    String time;

    @TableField("content")
    String content;

    @TableField("result")
    String result;
}
