package com.yizhischool.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhischool.common.context.BaseContext;
import com.yizhischool.mapper.ClassLogMapper;
import com.yizhischool.mapper.StudentMapper;
import com.yizhischool.pojo.Entity.ClassLog;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.pojo.VO.ClassLogVO;
import com.yizhischool.service.IClassLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassLogServiceImpl extends ServiceImpl<ClassLogMapper, ClassLog> implements IClassLogService {

    @Autowired
    private ClassLogMapper classLogMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ArrayList<ClassLogVO> getClassLog() {
        QueryWrapper<Student> studentWrapper = new QueryWrapper<Student>();
        Student student = studentMapper.selectOne(studentWrapper.eq("student_id", BaseContext.getCurrentId()));
        QueryWrapper<ClassLog> classLogWrapper = new QueryWrapper<ClassLog>();
        List<ClassLog> classLogs =classLogMapper.selectList(classLogWrapper.eq("belong", student.getBelong()));
        ArrayList<ClassLogVO> classLogVOS = new ArrayList<>();
        for(ClassLog classLog:classLogs){
            ClassLogVO classLogVO = ClassLogVO.builder()
                    .time(classLog.getTime())
                    .author(classLog.getAuthor())
                    .content(classLog.getContent())
                    .title(classLog.getTitle())
                    .build();
            classLogVOS.add(classLogVO);
        }
        return classLogVOS;
    }
}
