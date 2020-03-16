package com.sunlife.microorder.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;

    public Student(String name) {
        this.name = name;
    }
    public Student() {
    }
}
