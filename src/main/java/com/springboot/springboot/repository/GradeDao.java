package com.springboot.springboot.repository;

import com.springboot.springboot.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeDao extends JpaRepository<Grade, Integer> {
    Grade findById(int id);
    Grade findByNjuid(String njuid);
}
