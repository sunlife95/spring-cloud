package com.sunlife.microweb.health;

import com.sunlife.microweb.controller.OrderController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/2/29 22:21
 */
@Configuration
public class MicoWebHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (OrderController.canVisitDb) {
            return new Health.Builder(Status.UP).build();
        }else {
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
