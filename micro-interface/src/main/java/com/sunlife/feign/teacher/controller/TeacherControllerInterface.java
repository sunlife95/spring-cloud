package com.sunlife.feign.teacher.controller;

import com.sunlife.bean.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/feign/teacher")
public interface TeacherControllerInterface {

    @RequestMapping("/query")
    Teacher query(@RequestParam("id") Integer id);

    @RequestMapping("/save")
    Teacher save(@RequestBody Teacher teacher);
}
