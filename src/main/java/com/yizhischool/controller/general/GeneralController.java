package com.yizhischool.controller.general;

import com.yizhischool.common.result.Result;
import com.yizhischool.pojo.DTO.TeacherLoginDTO;
import com.yizhischool.pojo.VO.NotificationVO;
import com.yizhischool.service.INotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Tag(name="通用接口")
@RequestMapping("/general")
@Slf4j
public class GeneralController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping("/notification")
    @Operation(summary = "信息通知")
    public Result<ArrayList<NotificationVO>> notification() {
        return Result.success(notificationService.notificationGet());
    }
}
