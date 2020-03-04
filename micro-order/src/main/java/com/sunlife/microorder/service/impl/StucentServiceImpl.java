package com.sunlife.microorder.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sunlife.microorder.bean.Student;
import com.sunlife.microorder.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StucentServiceImpl implements StudentService {
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
}
