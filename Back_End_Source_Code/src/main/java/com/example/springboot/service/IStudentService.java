package com.example.springboot.service;

import com.example.springboot.controller.dto.studentLoginDTO;
import com.example.springboot.controller.request.StudentLoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Student;
import com.github.pagehelper.PageInfo;

public interface IStudentService {

    studentLoginDTO login(StudentLoginRequest request);

    void save(Student obj);

    void deleteByStudentNumber(Integer studentNumber);

    void update(Student obj);

    PageInfo<Student> page(StudentPageRequest studentPageRequest);

    Student getByStudentNumber(Integer studentNumber);
}
