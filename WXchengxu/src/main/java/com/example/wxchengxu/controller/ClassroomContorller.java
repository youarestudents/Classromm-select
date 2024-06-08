package com.example.wxchengxu.controller;

import com.example.wxchengxu.Classroom;
import com.example.wxchengxu.service.ClassroomSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping(value = "/yuyue")
public class ClassroomContorller {
    @Autowired
    private ClassroomSerive classroomSerive;
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/classroom",method = RequestMethod.GET)
    public List<Classroom> findall(){
        List<Classroom> classrooms=classroomSerive.findAll();//在数据库中遍历学生的信息并返回
        return classrooms;

    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/updaclass",method = RequestMethod.POST)
    public void updaclass(@RequestBody Classroom classroom){
        classroomSerive.updaclass(classroom.getUsedemo(),classroom.getId());
        System.out.println("修改成功");



    }

}
