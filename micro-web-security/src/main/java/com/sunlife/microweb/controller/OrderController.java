package com.sunlife.microweb.controller;

import com.sunlife.microweb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/user")
public class OrderController {

    private AtomicInteger s = new AtomicInteger();

    public static String SERVICE_NAME = "micro-order";

    public static Boolean canVisitDb = true;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderService orderService;

    @RequestMapping("/queryUser")
    public String queryUser(HttpServletRequest request) {
        s.incrementAndGet();
        String results = orderService.getOrder(request);
        return results;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/aa")
    public String aa(HttpServletRequest request) {
        System.out.println("aa");
        return "aa";
    }

    @PreAuthorize("hasRole('ROLE_MENU')")
    @RequestMapping("/bb")
    public String bb(HttpServletRequest request) {
        System.out.println("bb");
        return "bb";
    }

    @RequestMapping("/db/{can}")
    public void setDB(@PathVariable boolean can) {
        canVisitDb = can;
    }
}
