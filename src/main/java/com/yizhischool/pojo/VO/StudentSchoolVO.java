package com.yizhischool.pojo.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSchoolVO {

    @TableField("score")
    Integer score;

    @TableField("lesson")
    String lesson;

    @TableField("rank")
    String rank;

}
