package com.springboot.springboot.domain;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Table(name = "attendance")
@Entity
public class AtdInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String njuid;
    private String sname;

    // 使用 HashMap 作为 Map 的具体实现
    @ElementCollection
    @CollectionTable(
            name = "states",
            joinColumns = @JoinColumn(name = "id")
    )
    // 使用 Map 的键值类型作为参数
    @MapKeyColumn(name = "state_key")
    @Column(name = "state_value")
    private Map<String, String> states = new HashMap<>();

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Map<String, String> getStates() {
        return states;
    }

    public void setStates(Map<String, String> states) {
        this.states = states;
    }
}