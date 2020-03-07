package com.sunlife.microweb.feign.service.impl;

import com.sunlife.bean.Teacher;
import com.sunlife.microweb.feign.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherServiceFallback implements TeacherService {
    @Override
    public Teacher query(Integer id) {
        log.info("=========teacherServie.query   fallback==========");
        return null;
    }

    @Override
    public Teacher save(Teacher teacher) {
        log.info("=========teacherServie.save   fallback==========");
        return null;
    }
}
