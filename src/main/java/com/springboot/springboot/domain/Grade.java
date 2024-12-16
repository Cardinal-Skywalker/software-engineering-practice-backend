package com.springboot.springboot.domain;

import jakarta.persistence.*;

@Table(name = "grade")
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String njuid;
    private String sname;
    private double middle;
    private double finall;

    public Grade(Student student) {
        this.id = (int) student.getId();
        this.njuid = student.getNjuid();
        this.sname = student.getSname();
        this.middle = 0;
        this.finall = 0;
    }
    public Grade(String njuid, String middle, String finall) {
        this.njuid = njuid;
        this.middle = Double.parseDouble(middle);
        this.finall = Double.parseDouble(finall);
    }
    public Grade() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNjuid() {
        return njuid;
    }

    public void setNjuid(String njuid) {
        this.njuid = njuid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getMiddle() {
        return middle;
    }

    public void setMiddle(double middle) {
        this.middle = middle;
    }

    public double getFinall() {
        return finall;
    }

    public void setFinall(double finall) {
        this.finall = finall;
    }
}
