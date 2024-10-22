package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.Student;
import com.springboot.springboot.repository.StudentDao;
import com.springboot.springboot.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Student displayStudentService(long id) {
        Student student = studentDao.findById(id);
        return student;
    }
}
