package com.sunlife.microweb.feign.controller;

import com.sunlife.bean.Teacher;
import com.sunlife.microweb.feign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/query")
    public Teacher query(Integer id) {
        return teacherService.query(id);
    }

    @RequestMapping("/save")
    public Teacher save(Teacher teacher) {
        return teacherService.save(teacher);
    }

}
