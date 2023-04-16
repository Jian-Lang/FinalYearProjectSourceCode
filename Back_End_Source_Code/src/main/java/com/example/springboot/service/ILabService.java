package com.example.springboot.service;

import com.example.springboot.controller.dto.LabListDTO;
import com.example.springboot.controller.request.LabPageRequest;
import com.example.springboot.entity.Lab;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ILabService {
    void save(Lab lab);


    void deleteByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab);

    void updateSizeOfGroup(Lab obj);

    PageInfo<Lab> page(LabPageRequest labPageRequest);

    Lab getByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab);

    List<LabListDTO> listByTeacherNumberAndCourse(Integer teacherNumber, String course);

    void updateStateOfLab(Lab obj);
}
