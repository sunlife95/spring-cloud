package com.sunlife.microweb.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sunlife.microweb.service.StudentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class StudentServiceImpl implements StudentService {
    private static String SERVICE_NAME = "micro-order";

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            commandKey = "queryStudent",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "100"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000000000")
            }
    )
    @Override
    public String query(Integer id) {
        log.info(Thread.currentThread().getName() + "========queryStudent=========");
        String results = restTemplate.getForObject("http://" +
                SERVICE_NAME + "/student/query", String.class);
        return results;
    }
}
