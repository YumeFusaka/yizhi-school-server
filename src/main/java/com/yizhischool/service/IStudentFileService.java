package com.yizhischool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.pojo.Entity.StudentFile;
import com.yizhischool.pojo.VO.StudentFileVO;

import java.util.ArrayList;

public interface IStudentFileService extends IService<StudentFile> {
    ArrayList<StudentFileVO> getStudentFile();
}
