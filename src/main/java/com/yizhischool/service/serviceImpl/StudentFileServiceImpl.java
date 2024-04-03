package com.yizhischool.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhischool.common.context.BaseContext;
import com.yizhischool.mapper.StudentFileMapper;
import com.yizhischool.pojo.Entity.StudentFile;
import com.yizhischool.pojo.VO.StudentFileVO;
import com.yizhischool.service.IStudentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentFileServiceImpl extends ServiceImpl<StudentFileMapper, StudentFile> implements IStudentFileService {

    @Autowired
    private StudentFileMapper studentFileMapper;

    @Override
    public ArrayList<StudentFileVO> getStudentFile() {
        List<StudentFile> studentFiles = studentFileMapper.selectList(new QueryWrapper<StudentFile>().eq("student_id", BaseContext.getCurrentId()));
        ArrayList<StudentFileVO> studentFileVOS = new ArrayList<>();
        for (StudentFile studentFile: studentFiles) {
            StudentFileVO studentFileVO = StudentFileVO.builder()
                    .content(studentFile.getContent())
                    .rap(studentFile.getRap())
                    .result(studentFile.getResult())
                    .time(studentFile.getTime())
                    .build();
            studentFileVOS.add(studentFileVO);
        }
        return studentFileVOS;
    }
}
