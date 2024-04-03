package com.yizhischool.pojo.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherProfileVO {
    @TableId(value = "id",type = IdType.AUTO)
    Long id;

    @TableField("account")
    String account;

    @TableField("password")
    String password;

    @TableField("name")
    String name;

    @TableField("teacher_id")
    String teacher_id;

    @TableField("age")
    String age;

    @TableField("sex")
    String sex;

    @TableField("birth")
    String birth;

    @TableField("id_number")
    String id_number;

    @TableField("avatar")
    String avatar;

    @TableField("political")
    String political;

    @TableField("hometown")
    String hometown;

    @TableField("department")
    String department;

    @TableField("classes")
    String classes;

    @TableField("major")
    String major;

    @TableField("belong")
    String belong;

    @TableField("phone")
    String phone;
}
