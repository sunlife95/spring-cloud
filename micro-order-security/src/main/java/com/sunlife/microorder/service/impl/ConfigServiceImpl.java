package com.sunlife.microorder.service.impl;

import com.sunlife.microorder.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/3/14 17:21
 */
@Service
//@RefreshScope
public class ConfigServiceImpl implements ConfigService {

    @Value("${name}")
    private String name;

    @Value("${mypassword}")
    private String mypassword;

    @Autowired
    private Environment environment;

    @Override
    public int printConfig() {
        System.out.println("service Hashcode:" + this.hashCode());
        System.out.println("@Value name:" + name);
        System.out.println("@Value myPassword:" + mypassword);
        System.out.println("environment name:" + environment.getProperty("name"));
        System.out.println("environment myPassword:" + environment.getProperty("myPassword"));
        return this.hashCode();
    }
}
