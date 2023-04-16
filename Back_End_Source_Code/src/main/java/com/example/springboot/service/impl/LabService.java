package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.LabListDTO;
import com.example.springboot.controller.request.LabPageRequest;
import com.example.springboot.entity.Lab;
import com.example.springboot.mapper.LabMapper;
import com.example.springboot.service.ILabService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LabService implements ILabService {
    @Autowired
    LabMapper labMapper;

    @Override
    public void save(Lab lab) {
        labMapper.save(lab);
    }

    @Override
    public void deleteByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab) {
        labMapper.deleteByTeacherNumberAndCourseAndLab(teacherNumber,course,lab);
    }

    @Override
    public void updateSizeOfGroup(Lab obj) {
        obj.setUpdatetime(new Date());
        labMapper.updateSizeOfGroupByTeacherNumberAndCourseAndLab(obj);
    }

    @Override
    public PageInfo<Lab> page(LabPageRequest labPageRequest) {

        PageHelper.startPage(labPageRequest.getPageNum(),labPageRequest.getPageSize());
        List<Lab> labs = labMapper.listByCondition(labPageRequest);

        return new PageInfo<>(labs);

    }

    @Override
    public Lab getByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab) {
        return labMapper.getByTeacherNumberAndCourseAndLab(teacherNumber,course,lab);
    }

    @Override
    public List<LabListDTO> listByTeacherNumberAndCourse(Integer teacherNumber, String course) {

        List <LabListDTO> labListDTOS = labMapper.listByTeacherNumberAndCourse(teacherNumber,course);
        return labListDTOS;

    }

    @Override
    public void updateStateOfLab(Lab obj) {
        labMapper.updateStateOfGroupByTeacherNumberAndCourseAndLab(obj);
    }


}
