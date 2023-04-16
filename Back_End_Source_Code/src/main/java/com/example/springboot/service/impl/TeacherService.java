package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.teacherLoginDTO;

import com.example.springboot.controller.request.TeacherLoginRequest;

import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Teacher;
import com.example.springboot.exception.ServiceException;

import com.example.springboot.mapper.TeacherMapper;
import com.example.springboot.service.ITeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TeacherService implements ITeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public teacherLoginDTO login(TeacherLoginRequest request) {
        Teacher teacher = teacherMapper.getByTeacherNumberAndPassword(request);
        if (teacher == null){
            throw new ServiceException("用户名或密码错误");
        }
        teacherLoginDTO loginDTO = new teacherLoginDTO();
        BeanUtils.copyProperties(teacher, loginDTO);
        return loginDTO;
    }

    @Override
    public void save(Teacher obj) {
        teacherMapper.save(obj);
    }

    @Override
    public void deleteByTeacherNumber(Integer teacherNumber) {
        teacherMapper.deleteByTeacherNumber(teacherNumber);
    }

    @Override
    public void update(Teacher obj) {
        obj.setUpdatetime(new Date());
        teacherMapper.updateByTeacherNumber(obj);
    }

    @Override
    public PageInfo<Teacher> page(TeacherPageRequest teacherPageRequest) {

        PageHelper.startPage(teacherPageRequest.getPageNum(),teacherPageRequest.getPageSize());
        List<Teacher> teachers = teacherMapper.listByCondition(teacherPageRequest);
        return new PageInfo<>(teachers);
    }

    @Override
    public Teacher getByTeacherNumber(Integer teacherNumber) {
        return teacherMapper.getByTeacherNumber(teacherNumber);
    }


}
