package com.example.wxchengxu.dao;

import com.example.wxchengxu.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
@Select("select * from student ")
List<Student> findAll();
}
