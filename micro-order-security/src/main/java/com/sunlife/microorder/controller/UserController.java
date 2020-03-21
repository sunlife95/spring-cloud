package com.sunlife.microorder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/user")
public class UserController {

    public static Boolean CAN_RESULT = true;

    @RequestMapping("/queryUser")
    public String queryUser() {
        if (CAN_RESULT) {
            log.info("micro-order====queryUser");
            return "micro-order====queryUser";
        } else {
            int a = 1/0;
            return "micro-order====queryUser====failed";
        }
    }

    @RequestMapping("/canResult/{canResult}")
    public String setCanResult(@PathVariable Boolean canResult) {
        CAN_RESULT = canResult;
        return CAN_RESULT.toString();
    }
}
