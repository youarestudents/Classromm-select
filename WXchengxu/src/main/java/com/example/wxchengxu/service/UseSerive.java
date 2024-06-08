package com.example.wxchengxu.service;

import com.example.wxchengxu.Student;
import com.example.wxchengxu.Use;
import com.example.wxchengxu.dao.UseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseSerive {
    @Autowired
 private UseMapper useMapper;
    public void insertS( int classid,String id, int persons,int computers,long overtime){
        useMapper.charu( classid,id,persons,computers,overtime);
    }
    public List<Use> findAll() {
        try {
            return useMapper.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
