package com.example.springboot.service;

import com.example.springboot.controller.dto.teacherLoginDTO;
import com.example.springboot.controller.request.TeacherLoginRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Teacher;
import com.github.pagehelper.PageInfo;

public interface ITeacherService {


    teacherLoginDTO login(TeacherLoginRequest request);

    void save(Teacher obj);

    void deleteByTeacherNumber(Integer teacherNumber);

    void update(Teacher obj);

    PageInfo<Teacher> page(TeacherPageRequest teacherPageRequest);

    Teacher getByTeacherNumber(Integer teacherNumber);
}
