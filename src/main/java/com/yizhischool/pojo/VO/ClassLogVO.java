package com.yizhischool.pojo.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassLogVO {
    String content;

    String time;

    String author;

    String title;
}
