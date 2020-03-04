package com.sunlife.microweb.controller;

import com.sunlife.microweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/query")
    public String query(Integer id) {
        return studentService.query(id);
    }

}
