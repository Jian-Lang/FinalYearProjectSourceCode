package com.example.springboot.service.impl;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.request.CourseSelectPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.CourseSelect;
import com.example.springboot.mapper.CourseMapper;
import com.example.springboot.mapper.CourseSelectMapper;
import com.example.springboot.service.ICourseSelectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CourseSelectService implements ICourseSelectService {
    @Autowired
    CourseSelectMapper courseSelectMapper;

    @Override
    public void save(CourseSelect obj) {
        courseSelectMapper.save(obj);
    }

    @Override
    public void deleteByStudentNumberAndCourse(Integer studentNumber, String course) {
        courseSelectMapper.deleteByStudentNumberAndCourse(studentNumber,course);
    }

    @Override
    public PageInfo<CourseSelect> page(CourseSelectPageRequest courseSelectPageRequest) {

        PageHelper.startPage(courseSelectPageRequest.getPageNum(),courseSelectPageRequest.getPageSize());
        List<CourseSelect> courseSelects = courseSelectMapper.listByCondition(courseSelectPageRequest);
        return new PageInfo<>(courseSelects);
    }

    @Override
    public List<CourseListDTO> listByTeacherNumber(Integer teacherNumber) {

        List <CourseListDTO> courseListDTOS = courseSelectMapper.listByTeacherNumber(teacherNumber);
        return courseListDTOS;
    }

    @Override
    public Integer countByTeacherNumberAndCourse(Integer teacherNumber, String course) {

        return courseSelectMapper.countByTeacherNumberAndCourse(teacherNumber,course);
    }


}
