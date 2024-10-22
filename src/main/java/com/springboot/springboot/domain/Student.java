package com.springboot.springboot.domain;

import jakarta.persistence.*;

@Table(name = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String njuid;
    private String sname;
    private Object photo;

    public String getNjuid() {
        return njuid;
    }

    public void setNjuid(String njuid) {
        this.njuid = njuid;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
