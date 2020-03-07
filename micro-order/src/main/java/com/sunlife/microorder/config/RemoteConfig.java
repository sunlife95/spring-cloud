package com.sunlife.microorder.config;

import com.sunlife.microorder.bean.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/3/7 21:54
 */
@Configuration
public class RemoteConfig {

    @Value("${name}")
    private String name;

    @Value("${mypassword}")
    private String mypassword;

    @Bean
    @ConditionalOnClass(Student.class)
    public void printName(){
        System.out.println(name);
        System.out.println(mypassword);
    }

}
