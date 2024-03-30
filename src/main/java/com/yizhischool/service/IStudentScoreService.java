package com.yizhischool.service;

import com.yizhischool.pojo.VO.StudentSchoolVO;

import java.util.ArrayList;

public interface IStudentScoreService {

    ArrayList<StudentSchoolVO> school (Integer semester);
}
