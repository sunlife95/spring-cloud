package com.sunlife.microweb.test;

import com.sunlife.microweb.MicroWebApplication;
import com.sunlife.microweb.service.OrderService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MicroWebApplication.class)
@WebAppConfiguration
public class MyTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer count = 11;

    private CountDownLatch cdl = new CountDownLatch(count);

    @Autowired
    OrderService orderService;

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Test
    public void test1() {

        for (Integer i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    logger.info(Thread.currentThread().getName() + "==>" + orderService.getOrder());
                }
            }).start();
            cdl.countDown();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @PerfTest(invocations = 11, threads = 11)
    public void test2(){
        logger.info(Thread.currentThread().getName() + "==>" + orderService.getOrder());
    }
}
