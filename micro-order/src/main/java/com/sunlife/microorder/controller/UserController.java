package com.sunlife.microorder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/2/26 22:48
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping("/queryUser")
    public String queryUser() {
        log.info("micro-order====queryUser");
        return "micro-order====queryUser";
    }
}
