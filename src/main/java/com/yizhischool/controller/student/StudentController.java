package com.yizhischool.controller.student;


import com.yizhischool.common.context.BaseContext;
import com.yizhischool.common.properties.JwtProperties;
import com.yizhischool.pojo.DTO.StudentLoginDTO;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.pojo.VO.*;
import com.yizhischool.service.*;
import com.yizhischool.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yizhischool.common.result.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name="学生相关接口")
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IStudentScoreService studentScoreService;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private IClassLogService classLogService;

    @Autowired
    private IStudentFileService studentFileService;


    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<StudentLoginVO> login(@RequestBody StudentLoginDTO studentLoginDTO){
        log.info("学生用户登录:{}",studentLoginDTO);
        Student student = studentService.login(studentLoginDTO);
        Map<String,Object> claims = new HashMap<>();
        claims.put("studentId",student.getStudent_id());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        StudentLoginVO studentPersonalVO = StudentLoginVO.builder().token(token).build();
        log.info("返回token:{}",token);
        return Result.success(studentPersonalVO);
    }

    @PostMapping("/profile")
    @Operation(summary = "用户信息")
    public Result<StudentProfileVO> profile(){
        Student student = studentService.profile();
        log.info("学生用户信息:{}", student);
        return Result.success(StudentProfileVO.builder()
                        .name(student.getName())
                        .student_id(student.getStudent_id())
                        .age(student.getAge())
                        .sex(student.getSex())
                        .birth(student.getBirth())
                        .id_number(student.getId_number())
                        .avatar(student.getAvatar())
                        .political(student.getPolitical())
                        .hometown(student.getHometown())
                        .department(student.getDepartment())
                        .classes(student.getClasses())
                        .major(student.getMajor())
                        .phone(student.getPhone())
                        .build()
                );
    }


    @GetMapping("/school")
    @Operation(summary = "学籍成绩")
    public Result<ArrayList<StudentSchoolVO>> school(@RequestParam Integer semester) {
        log.info("查询的学号是:{} 查询的学年是:{}", BaseContext.getCurrentId(), semester);
        return Result.success(studentScoreService.school(semester));
    }

    @PostMapping("/class_log")
    @Operation(summary = "班级日志")
    public Result<ArrayList<ClassLogVO>> classLog(){
        return Result.success(classLogService.getClassLog());
    }

    @PostMapping("/file")
    @Operation(summary = "学生档案")
    public Result<ArrayList<StudentFileVO>> file(){
        return Result.success(studentFileService.getStudentFile());
    }

    @GetMapping("/hello")
    public Result<String> hello(){
        return Result.success("hello");
    }

}
