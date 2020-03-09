package com.sunlife.microorder.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sunlife.microorder.bean.Student;
import com.sunlife.microorder.dao.StudentDao;
import com.sunlife.microorder.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class StucentServiceImpl implements StudentService {

    private Integer count = 4;

    private CountDownLatch cdl = new CountDownLatch(count);

    private StudentDao studentDao;

    @Override
    public String errorMsg(Integer id) {
        try {
//            Student student = studentMapper.queryStudentById(id);
            Student student = new Student();
            int a = 1 / 0;
            return JSONObject.toJSONString(student);
        }catch (Exception e) {
            e.printStackTrace();
//            return e.getMessage();
            throw e;
        }
    }

    @Override
    public int testBatchInsert() {
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    List<Student> lists = new ArrayList<>();
                    for (int i = 0; i < 500; i++) {
                        lists.add(new Student(Thread.currentThread().getName()));
                    }
                    for (Student student: lists) {
                        System.out.println(student.getName());
                    }
                    System.out.println(studentDao.insertBatch(lists));
                }
            }).start();
            cdl.countDown();
        }
        return 0;
    }
}
