package com.example.wxchengxu.dao;

import com.example.wxchengxu.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    @Select("select * from class")
    List<Classroom> findAll();
    @Update("update class set usedemo=#{use} where id=#{id} ")
    void updaclass(boolean use,int id);
}
