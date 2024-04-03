package com.yizhischool.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhischool.common.context.BaseContext;
import com.yizhischool.mapper.TeacherMapper;
import com.yizhischool.pojo.DTO.TeacherLoginDTO;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.pojo.Entity.Teacher;
import com.yizhischool.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(TeacherLoginDTO teacherLoginDTO) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("account",teacherLoginDTO.getAccount())
                .eq("password", teacherLoginDTO.getPassword());
        Teacher teacher = teacherMapper.selectOne(wrapper);
        if(teacher == null){
            throw new RuntimeException("账号或密码错误");
        }
        return teacher;
    }

    @Override
    public Teacher profile() {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", BaseContext.getCurrentId());
        return teacherMapper.selectOne(wrapper);
    }
}
