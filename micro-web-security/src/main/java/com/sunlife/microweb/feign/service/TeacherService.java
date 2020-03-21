package com.sunlife.microweb.feign.service;

import com.sunlife.feign.teacher.controller.TeacherControllerInterface;
import com.sunlife.microweb.feign.service.impl.TeacherServiceFallback;
import com.sunlife.microweb.feign.service.impl.TeacherServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "micro-order-security",
//        fallback = TeacherServiceFallback.class,
        fallbackFactory = TeacherServiceFallbackFactory.class
)
public interface TeacherService extends TeacherControllerInterface {

}
