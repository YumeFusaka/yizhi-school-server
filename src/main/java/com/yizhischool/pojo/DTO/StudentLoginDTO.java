package com.yizhischool.pojo.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class StudentLoginDTO {
    String account;
    String password;
}
