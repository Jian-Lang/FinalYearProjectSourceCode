package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.dto.adminLoginDTO;
import com.example.springboot.controller.request.CoursePageRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.CourseMapper;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.ICourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public void save(Course obj) {

        courseMapper.save(obj);
    }

    @Override
    public void deleteByStudentNumberAndCourse(Integer studentNumber, String course) {
        courseMapper.deleteByStudentNumberAndCourse(studentNumber,course);
    }

    @Override
    public void update(Course obj) {
        obj.setUpdatetime(new Date());
        courseMapper.updateByStudentNumberAndCourse(obj);
    }

    @Override
    public PageInfo<Course> page(CoursePageRequest coursePageRequest) {

        PageHelper.startPage(coursePageRequest.getPageNum(),coursePageRequest.getPageSize());
        List<Course> courses = courseMapper.listByCondition(coursePageRequest);
        return new PageInfo<>(courses);
    }

    @Override
    public Course getByStudentNumberAndCourse(Integer studentNumber, String course) {

        return courseMapper.getByStudentNumberAndCourse(studentNumber,course);
    }


}
