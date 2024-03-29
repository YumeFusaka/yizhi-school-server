package com.yizhischool.controller.student;


import com.yizhischool.common.properties.JwtProperties;
import com.yizhischool.pojo.DTO.StudentLoginDTO;
import com.yizhischool.pojo.Entity.Student;
import com.yizhischool.pojo.VO.StudentPersonalVO;
import com.yizhischool.service.IStudentService;
import com.yizhischool.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yizhischool.common.result.Result;

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
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<StudentPersonalVO> login(@RequestBody StudentLoginDTO studentLoginDTO){
        log.info("学生用户登录:{}",studentLoginDTO);
        Student student = studentService.login(studentLoginDTO);
        Map<String,Object> claims = new HashMap<>();
        claims.put("studentId",student.getStudent_id());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        StudentPersonalVO studentPersonalVO = StudentPersonalVO.builder()
                .account(student.getAccount())
                .password(student.getPassword())
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
                .classes(student.getClasses()).
                major(student.getMajor()).
                token(token).
                build();
        log.info("返回token:{}",token);
        return Result.success(studentPersonalVO);
    }

    @GetMapping("/hello")
    public Result<String> hello(){
        return Result.success("hello");
    }

}
