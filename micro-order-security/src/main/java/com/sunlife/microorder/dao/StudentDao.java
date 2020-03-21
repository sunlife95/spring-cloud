package com.sunlife.microorder.dao;

import com.sunlife.microorder.bean.Student;

import java.util.List;

/**
 * 类描述
 *
 * @author sunlife
 * @version 1.0
 * @date 2020/3/9 22:27
 */
public interface StudentDao {
    int insertBatch(List<Student> students);
}
