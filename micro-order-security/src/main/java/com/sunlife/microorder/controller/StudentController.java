package com.sunlife.microorder.controller;

import com.sunlife.microorder.service.StudentService;
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
        return studentService.errorMsg(id);
    }


    @RequestMapping("/test")
    public String test(Integer id) {
        studentService.testBatchInsert();
        return "ok";
    }


}

