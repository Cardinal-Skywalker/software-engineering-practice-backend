package com.springboot.springboot.service;

import com.springboot.springboot.domain.Attendance;

public interface AttendanceService {
    void mysave(Attendance attendance);
    Attendance displayAttendanceService(String njuid, String date);
}
