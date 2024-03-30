package com.yizhischool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhischool.pojo.DTO.StudentLoginDTO;
import com.yizhischool.pojo.Entity.Student;

public interface IStudentService extends IService<Student> {
    Student login(StudentLoginDTO studentLoginDTO);

    Student profile();

}
