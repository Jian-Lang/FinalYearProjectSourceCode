package com.example.springboot.mapper;


import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.request.CourseSelectPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.CourseSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseSelectMapper {


    void save(CourseSelect obj);

    void deleteByStudentNumberAndCourse(Integer studentNumber, String course);


    List<CourseSelect> listByCondition(CourseSelectPageRequest courseSelectPageRequest);

    List<CourseListDTO> listByTeacherNumber(Integer teacherNumber);

    Integer countByTeacherNumberAndCourse(Integer teacherNumber, String course);
}
