package com.example.springboot.mapper;

import com.example.springboot.controller.dto.LabListDTO;
import com.example.springboot.controller.request.LabPageRequest;
import com.example.springboot.entity.Lab;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabMapper {

    void save(Lab lab);


    void deleteByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab);

    void updateSizeOfGroupByTeacherNumberAndCourseAndLab(Lab obj);

    List<Lab> listByCondition(LabPageRequest labPageRequest);

    Lab getByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab);


    List<LabListDTO> listByTeacherNumberAndCourse(Integer teacherNumber, String course);

    void updateStateOfGroupByTeacherNumberAndCourseAndLab(Lab obj);
}
