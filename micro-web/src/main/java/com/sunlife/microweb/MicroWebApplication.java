package com.sunlife.microweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
// 开启断路器
@EnableCircuitBreaker
public class MicroWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWebApplication.class, args);
    }

    @Bean
    // 负载均衡注解
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}