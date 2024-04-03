package com.yizhischool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhischool.pojo.Entity.Score;
import com.yizhischool.pojo.VO.StudentSchoolVO;

import java.util.ArrayList;

public interface IStudentScoreService extends IService<Score> {

    ArrayList<StudentSchoolVO> school (Integer semester);
}
