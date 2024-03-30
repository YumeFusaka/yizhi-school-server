package com.yizhischool.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhischool.common.context.BaseContext;
import com.yizhischool.mapper.StudentMapper;
import com.yizhischool.pojo.DTO.StudentLoginDTO;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(StudentLoginDTO studentLoginDTO) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("account",studentLoginDTO.getAccount())
                .eq("password", studentLoginDTO.getPassword());
        return studentMapper.selectOne(wrapper);
    }

    @Override
    public Student profile() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("student_id",BaseContext.getCurrentId());
        BaseContext.removeCurrentId();
        return studentMapper.selectOne(wrapper);
    }
}
