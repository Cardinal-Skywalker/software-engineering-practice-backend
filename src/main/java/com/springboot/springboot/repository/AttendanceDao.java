package com.springboot.springboot.repository;

import com.springboot.springboot.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AttendanceDao extends JpaRepository<Attendance, Long> {
    Attendance findByNjuid(String njuid);
    Attendance findById(long id);
    @Query(value = "SELECT COUNT(*) FROM information_schema.columns WHERE table_name = 'attendance' AND column_name =:date", nativeQuery = true)
    Integer queryForDate(@Param("date") String date);

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE attendance SET :columnName =:state WHERE njuid =:id", nativeQuery = true)
//    void mysave(@Param("columnName") String date ,@Param("id") String njuid,@Param("state") String state);
}