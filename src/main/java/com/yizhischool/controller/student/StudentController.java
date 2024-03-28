package com.yizhischool.controller.student;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="学生相关接口")
public class StudentController {
    @RequestMapping("/student/hello")
    @Operation(summary = "用户登录")
    public String hello(){
        System.out.println("hello world");
        return "hello world";
    }

}
