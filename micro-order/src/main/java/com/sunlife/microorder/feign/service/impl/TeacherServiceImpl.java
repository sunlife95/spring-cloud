package com.sunlife.microorder.feign.service.impl;

import com.sunlife.bean.Teacher;
import com.sunlife.microorder.feign.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Override
    public Teacher query(Integer id) {
        return new Teacher(id, "张三", 26);
    }
}
