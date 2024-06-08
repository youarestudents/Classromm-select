package com.example.wxchengxu.service;

import com.example.wxchengxu.Classroom;
import com.example.wxchengxu.dao.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomSerive {
    @Autowired
private ClassroomMapper classroomMapper;

    public List<Classroom> findAll() {
        try {
           return classroomMapper.findAll();
        }catch ( Exception e){
           e.printStackTrace();
           return  null;
        }

    }
    public void updaclass(boolean use,int id){
        try {
            classroomMapper.updaclass(use,id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
