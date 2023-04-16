package com.example.springboot.mapper;

import com.example.springboot.controller.request.TeacherLoginRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    Teacher getByTeacherNumberAndPassword(TeacherLoginRequest request);

    void save(Teacher obj);

    void deleteByTeacherNumber(Integer teacherNumber);

    void updateByTeacherNumber(Teacher obj);

    List<Teacher> listByCondition(TeacherPageRequest teacherPageRequest);

    Teacher getByTeacherNumber(Integer teacherNumber);
}

