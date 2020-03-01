package com.sunlife.microweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/2/26 22:54
 */
@RestController
@Slf4j
public class OrderController {

    private AtomicInteger s = new AtomicInteger();

    public static String SERVICE_NAME = "micro-order";

    public static Boolean canVisitDb = false;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/queryUser")
    public String queryUser() {
        s.incrementAndGet();
        String results = restTemplate.getForObject("http://" +
                SERVICE_NAME + "/queryUser", String.class);
        return results;
    }

    @RequestMapping("/db/{can}")
    public void setDB(@PathVariable boolean can) {
        canVisitDb = can;
    }
}
