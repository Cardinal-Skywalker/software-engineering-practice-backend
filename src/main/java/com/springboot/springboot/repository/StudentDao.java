package com.springboot.springboot.repository;

import com.springboot.springboot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
    Student findByNjuid(String njuid);
    Student findById(long id);
}
