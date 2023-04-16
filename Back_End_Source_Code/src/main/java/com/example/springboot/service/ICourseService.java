package com.example.springboot.service;

import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.request.CoursePageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.github.pagehelper.PageInfo;

public interface ICourseService {
    void save(Course obj);

    void deleteByStudentNumberAndCourse(Integer studentNumber, String course);

    void update(Course obj);

    PageInfo<Course> page(CoursePageRequest coursePageRequest);

    Course getByStudentNumberAndCourse(Integer studentNumber, String course);


}
