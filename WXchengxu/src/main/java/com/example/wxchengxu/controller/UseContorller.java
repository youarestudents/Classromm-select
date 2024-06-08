package com.example.wxchengxu.controller;

import com.example.wxchengxu.Use;
import com.example.wxchengxu.service.UseSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/insert/use")
public class UseContorller {
    @Autowired
    private UseSerive useSerive;
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/useclassroom",method = RequestMethod.POST)
    public void Useclassroom(@RequestBody Use use){
        useSerive.insertS(use.getClassid(),use.getSid(), use.getPersons(),use.getComputers(),use.getOvertime());
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findclassroom",method = RequestMethod.GET)
    public List<Use> findAll(){
        return useSerive.findAll();

    }

}
