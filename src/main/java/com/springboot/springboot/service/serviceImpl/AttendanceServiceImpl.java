package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.Attendance;
import com.springboot.springboot.repository.AttendanceDao;
import jakarta.annotation.Resource;
import com.springboot.springboot.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceDao attendanceDao;

    @Override
    public void mysave(Attendance attendance) {
        Integer existcount = attendanceDao.queryForDate(attendance.getDate());
        if(existcount==0) {
            addDataColumnToAttendanceTable(attendance.getDate());
            mysave(attendance.getDate(),attendance.getNjuid(),  attendance.getState());
        }else{
            mysave(attendance.getDate(), attendance.getNjuid(), attendance.getState());
        }
    }

    @Override
    public Attendance displayAttendanceService(String njuid, String date) {
        Attendance attendance = attendanceDao.findByNjuid(njuid);
        return attendance;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addDataColumnToAttendanceTable(String columnName) {
        String sql = "ALTER TABLE attendance ADD COLUMN `" + columnName +"` VARCHAR(30)"; // 以VARCHAR为例，根据需要更改数据类型
        jdbcTemplate.execute(sql);
    }
    public void mysave(String date, String njuid, String state) {
        String sql = "UPDATE attendance SET `"+date+"` = '"+ state+"' WHERE njuid ='"+njuid+"'";
        jdbcTemplate.execute(sql);
    }
}
