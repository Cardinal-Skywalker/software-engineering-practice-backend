package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.Attendance;
import com.springboot.springboot.domain.Student;
import com.springboot.springboot.repository.AttendanceDao;
import com.springboot.springboot.repository.StudentDao;
import com.springboot.springboot.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public Student displayStudentService(long id) {
        Student student = studentDao.findById(id);
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    public void save(Student student, Attendance attendance) {
        attendanceDao.FirstSave(attendance.getId(),attendance.getNjuid(),attendance.getSname());
        //String sql = "INSERT INTO attendance VALUES()"

        studentDao.save(student);
        return;
    }

}
