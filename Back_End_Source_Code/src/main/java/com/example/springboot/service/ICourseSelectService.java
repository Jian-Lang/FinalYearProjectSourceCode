package com.example.springboot.service;

import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.request.CourseSelectPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.CourseSelect;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICourseSelectService {

    void save(CourseSelect obj);

    void deleteByStudentNumberAndCourse(Integer studentNumber, String course);


    PageInfo<CourseSelect> page(CourseSelectPageRequest courseSelectPageRequest);

    List<CourseListDTO> listByTeacherNumber(Integer teacherNumber);

    Integer countByTeacherNumberAndCourse(Integer teacherNumber, String course);
}
