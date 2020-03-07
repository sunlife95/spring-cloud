package com.sunlife.microorder.feign.controller;

import com.sunlife.bean.Teacher;
import com.sunlife.feign.teacher.controller.TeacherControllerInterface;
import com.sunlife.microorder.feign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController implements TeacherControllerInterface {
    @Autowired
    TeacherService teacherService;

    @Override
    public Teacher query(@RequestParam("id") Integer id) {
        return teacherService.query(id);
    }

    @Override
    public Teacher save(@RequestBody Teacher teacher) {
        return teacher;
    }
}
