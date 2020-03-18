package com.sunlife.microweb.feign.service.impl;

import com.sunlife.bean.Teacher;
import com.sunlife.microweb.feign.service.TeacherService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TeacherServiceFallbackFactory implements FallbackFactory<TeacherService> {
    @Override
    public TeacherService create(Throwable throwable) {
        if(throwable == null) {
            return null;
        }
        final String msg = throwable.getMessage();
        log.info("exception:" + msg);
        return new TeacherService() {
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
        };
    }
}
