package com.yizhischool.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yizhischool.pojo.Entity.ClassLog;
import com.yizhischool.pojo.VO.ClassLogVO;

import java.util.ArrayList;

public interface IClassLogService extends IService<ClassLog> {
    ArrayList<ClassLogVO> getClassLog();
}
