package com.sunlife.microweb.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private AtomicInteger s = new AtomicInteger();

    public static String SERVICE_NAME = "micro-order";

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
    public String getOrder() {
        log.info(Thread.currentThread().getName() + "========getOrder=========");
        s.incrementAndGet();
        String results = restTemplate.getForObject("http://" +
                SERVICE_NAME + "/queryUser", String.class);
        return results;
    }

    public String getOrderFallback() {
        log.info(Thread.currentThread().getName() + "========fallback=========");
        return Thread.currentThread().getName() + "========fallback=========";
    }
}
