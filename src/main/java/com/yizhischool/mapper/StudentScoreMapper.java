package com.yizhischool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yizhischool.pojo.Entity.Score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentScoreMapper extends BaseMapper<Score> {
}
