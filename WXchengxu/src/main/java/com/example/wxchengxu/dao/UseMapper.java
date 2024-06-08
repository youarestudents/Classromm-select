package com.example.wxchengxu.dao;

import com.example.wxchengxu.Use;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UseMapper {
    @Insert("insert into classusing (classid, sid,persons,computers,overtime) values( #{classid},#{sid},#{persons},#{computers},#{overtime})")
    void charu(int classid, String sid,int persons,int computers,long overtime);
    @Select("select * from classusing")
    List<Use> findAll();

}
