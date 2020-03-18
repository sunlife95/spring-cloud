package com.sunlife.microweb;

import com.sunlife.microweb.feign.service.TeacherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
// 开启断路器
@EnableCircuitBreaker

//开启feign支持，clients指定哪个类开启feign
@EnableFeignClients(clients = {TeacherService.class})
public class MicroWebSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWebSecurityApplication.class, args);
    }

    @Bean
    // 负载均衡注解
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
