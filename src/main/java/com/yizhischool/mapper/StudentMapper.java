package com.yizhischool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yizhischool.pojo.DTO.StudentLoginDTO;
import com.yizhischool.pojo.Entity.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}

