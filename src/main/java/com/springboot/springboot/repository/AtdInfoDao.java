package com.springboot.springboot.repository;

import com.springboot.springboot.domain.AtdInfo;
import com.springboot.springboot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtdInfoDao extends JpaRepository<AtdInfo, Long> {
    AtdInfo findById(long id);
}
