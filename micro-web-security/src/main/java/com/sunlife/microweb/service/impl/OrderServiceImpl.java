package com.sunlife.microweb.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sunlife.microweb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private AtomicInteger s = new AtomicInteger();

    public static String SERVICE_NAME = "micro-order-security";

    public static Boolean canVisitDb = false;

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getOrderFallback",
            commandKey = "getOrder",
            groupKey = "querygroup-one",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "100"),
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000000000")
            },
            threadPoolKey = "getOrderhystrixJackpool", threadPoolProperties = {
//            @HystrixProperty(name = "coreSize", value = "100")
    }
    )
    public String getOrder(HttpServletRequest request) {
        log.info(Thread.currentThread().getName() + "========getOrder=========");
        log.info(Thread.currentThread().getName() + "========queryContents=========");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", request.getHeader("Authorization"));
        String results = restTemplate.exchange("http://"
                        + SERVICE_NAME + "/user/queryUser", HttpMethod.GET,
                new HttpEntity<String>(headers), String.class).getBody();
        s.incrementAndGet();
        return results;
    }

    public String getOrderFallback(HttpServletRequest request) {
        log.info(Thread.currentThread().getName() + "========fallback=========");
        return Thread.currentThread().getName() + "========fallback=========";
    }
}
