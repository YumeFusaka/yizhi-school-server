package com.yizhischool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhischool.pojo.DTO.TeacherLoginDTO;
import com.yizhischool.pojo.Entity.Teacher;

public interface ITeacherService extends IService<Teacher> {
    Teacher login(TeacherLoginDTO teacherLoginDTO);

    Teacher profile();
}
