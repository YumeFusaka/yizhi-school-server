package com.yizhischool.pojo.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentProfileVO {
    String name;

    String student_id;

    String age;

    String sex;

    String birth;

    String id_number;

    String avatar;

    String political;

    String hometown;

    String department;

    String classes;

    String major;

    String phone;
}
