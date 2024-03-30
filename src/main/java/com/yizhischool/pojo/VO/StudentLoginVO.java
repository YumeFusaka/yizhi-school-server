package com.yizhischool.pojo.VO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentLoginVO {
    String token;
}