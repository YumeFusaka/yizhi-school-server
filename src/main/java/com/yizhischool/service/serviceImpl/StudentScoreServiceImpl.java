package com.yizhischool.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yizhischool.common.context.BaseContext;
import com.yizhischool.mapper.StudentScoreMapper;
import com.yizhischool.pojo.Entity.Score;
import com.yizhischool.pojo.VO.StudentSchoolVO;
import com.yizhischool.service.IStudentScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentScoreServiceImpl extends ServiceImpl<StudentScoreMapper, Score> implements IStudentScoreService {

    @Autowired
    private StudentScoreMapper studentScoreMapper;

    @Override
    public ArrayList<StudentSchoolVO> school(Integer semester) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("semester",semester).eq("student_id", BaseContext.getCurrentId());
        List<Score> scores = studentScoreMapper.selectList(wrapper);
        ArrayList<StudentSchoolVO> studentSchoolVOs = new ArrayList<>();
        for(Score score : scores){
            StudentSchoolVO studentSchoolVO = StudentSchoolVO.builder()
                    .score(score.getScore())
                    .lesson(score.getLesson())
                    .rank(score.getRank())
                    .build();
            studentSchoolVOs.add(studentSchoolVO);
        }
        return studentSchoolVOs;
    }
}
