package com.example.wxchengxu.service;

import com.example.wxchengxu.Student;
import com.example.wxchengxu.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentSerive {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAll() {
        try {
            return studentMapper.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
