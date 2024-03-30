package com.yizhischool.pojo.Entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("score")
public class Score {

    @TableId(value="id", type = IdType.AUTO)
    Long id;

    @TableField("name")
    String name;

    @TableField("score")
    Integer score;

    @TableField("lesson")
    String lesson;

    @TableField("belong")
    String belong;

    @TableField("`rank`")
    String rank;

    @TableField("semester")
    Integer semester;

    @TableField("student_id")
    String student_id;
}
