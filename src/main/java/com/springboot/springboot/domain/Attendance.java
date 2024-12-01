package com.springboot.springboot.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Map;

@Table(name = "attendance")
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String njuid;
    private String sname;
    private String date;
    private String state;
    public Attendance(Student student) {
        id = student.getId();
        njuid = student.getNjuid();
        sname = student.getSname();
        date = "0";
        state = "0";
    }

    public Attendance(String njuid, String date, String status) {
        this.njuid = njuid;
        this.date = date;
        this.state = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Attendance() {

    }

    public String getNjuid() {
        return njuid;
    }

    public void setNjuid(String njuid) {
        this.njuid = njuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


}
