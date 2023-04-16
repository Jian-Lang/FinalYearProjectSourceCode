package com.example.springboot.mapper;

import com.example.springboot.controller.request.StudentLoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    Student getByStudentNumberAndPassword(StudentLoginRequest request);

    void save(Student obj);

    void deleteByStudentNumber(Integer studentNumber);

    void updateByStudentNumber(Student obj);

    List<Student> listByCondition(StudentPageRequest studentPageRequest);

    Student getByStudentNumber(Integer studentNumber);
}
