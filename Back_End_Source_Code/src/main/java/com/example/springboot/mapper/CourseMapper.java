package com.example.springboot.mapper;

import com.example.springboot.controller.request.CoursePageRequest;
import com.example.springboot.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    void save(Course obj);

    void deleteByStudentNumberAndCourse(Integer studentNumber, String course);

    void updateByStudentNumberAndCourse(Course obj);

    List<Course> listByCondition(CoursePageRequest coursePageRequest);

    Course getByStudentNumberAndCourse(Integer studentNumber, String course);
}
