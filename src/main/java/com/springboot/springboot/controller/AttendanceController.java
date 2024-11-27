package com.springboot.springboot.controller;

import com.springboot.springboot.domain.Attendance;
import com.springboot.springboot.service.AttendanceService;
import com.springboot.springboot.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;

    @PostMapping("/startAtd")
    public Result<String> startAttendance(@RequestParam String njuid, @RequestParam String status, @RequestParam String date) {
        System.out.println("收到点名信息");
        Attendance newAttendance = new Attendance(njuid,date,status);
        attendanceService.mysave(newAttendance);
        return Result.success("000","点名成功！");
//        if (attendance != null) {
//            return Result.success("000","点名成功！");
//        }else{
//            return Result.error("456","点名错误！");
//        }
    }
}
