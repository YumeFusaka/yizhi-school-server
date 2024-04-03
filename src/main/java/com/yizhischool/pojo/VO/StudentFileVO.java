package com.yizhischool.pojo.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentFileVO {

    Integer rap;

    String time;

    String content;

    String result;
}
