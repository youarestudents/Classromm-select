package com.example.wxchengxu.controller;

import com.example.wxchengxu.Student;
import com.example.wxchengxu.service.StudentSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/select/address")
public class StudentContorller {
    @Autowired
    private StudentSerive studentSerive;
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/classroom",method = RequestMethod.GET)
    public List<Student> all(){
        List<Student> students=studentSerive.findAll();//在数据库中遍历学生的信息并返回
        return students;

    }

}
