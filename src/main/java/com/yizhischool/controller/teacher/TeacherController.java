package com.yizhischool.controller.teacher;

import com.yizhischool.common.properties.JwtProperties;
import com.yizhischool.common.result.Result;
import com.yizhischool.pojo.DTO.TeacherLoginDTO;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.pojo.Entity.Teacher;
import com.yizhischool.pojo.VO.StudentProfileVO;
import com.yizhischool.pojo.VO.TeacherLoginVO;
import com.yizhischool.pojo.VO.TeacherProfileVO;
import com.yizhischool.service.ITeacherService;
import com.yizhischool.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Tag(name = "教师相关接口")
@RestController
@RequestMapping("/teacher")
public class TeacherController{

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private JwtProperties jwtProperties;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<TeacherLoginVO> login(@RequestBody TeacherLoginDTO teacherLoginDTO){
        log.info("教师用户登录:{}",teacherLoginDTO);
        Teacher teacher = teacherService.login(teacherLoginDTO);
        Map<String,Object> claims = new HashMap<>();
        claims.put("teacherId",teacher.getTeacher_id());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        TeacherLoginVO teacherLoginVO = TeacherLoginVO.builder().token(token).build();
        log.info("返回token:{}",token);
        return Result.success(teacherLoginVO);
    }

    @PostMapping("/profile")
    @Operation(summary = "用户信息")
    public Result<TeacherProfileVO> profile(){
        Teacher teacher = teacherService.profile();
        log.info("学生用户信息:{}", teacher);
        return Result.success(TeacherProfileVO.builder()
                .name(teacher.getName())
                .teacher_id(teacher.getTeacher_id())
                .age(teacher.getAge())
                .sex(teacher.getSex())
                .birth(teacher.getBirth())
                .id_number(teacher.getId_number())
                .avatar(teacher.getAvatar())
                .political(teacher.getPolitical())
                .hometown(teacher.getHometown())
                .department(teacher.getDepartment())
                .classes(teacher.getClasses())
                .major(teacher.getMajor())
                .phone(teacher.getPhone())
                .build()
        );
    }

    @GetMapping("/hello")
    public Result<String> hello(){
        return Result.success("hello");
    }
}