package com.springboot.springboot.service;

import com.springboot.springboot.domain.Student;

public interface StudentService {
    Student displayStudentService(long id);
    Student save(Student student);
}

