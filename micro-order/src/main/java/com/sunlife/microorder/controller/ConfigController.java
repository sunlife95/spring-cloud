package com.sunlife.microorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlife.microorder.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/3/7 23:24
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${name}")
    private String name;

    @Value("${mypassword}")
    private String mypassword;

    @Autowired
    Environment environment;

    @RequestMapping("/getAllConfig")
    public String  printName(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("environment.name", environment.getProperty("name"));
        jsonObject.put("mypassword", mypassword);
        jsonObject.put("environment.mypassword", environment.getProperty("mypassword"));
        return jsonObject.toJSONString();
    }


}
