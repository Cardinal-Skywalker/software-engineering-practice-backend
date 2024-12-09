package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.Attendance;
import com.springboot.springboot.domain.Grade;
import com.springboot.springboot.domain.Student;
import com.springboot.springboot.repository.AttendanceDao;
import com.springboot.springboot.repository.GradeDao;
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
    @Autowired
    private GradeDao gradeDao;

    @Override
    public Student displayStudentService(long id) {
        Student student = studentDao.findById(id);
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    public void save(Student student, Attendance attendance, Grade grade) {
        if(attendanceDao.count()==0){
            attendanceDao.FirstSave(attendance.getId(),attendance.getNjuid(),attendance.getSname());
        }

        //String sql = "INSERT INTO attendance VALUES()"
        gradeDao.save(grade);
        studentDao.save(student);
        return;
    }

}
