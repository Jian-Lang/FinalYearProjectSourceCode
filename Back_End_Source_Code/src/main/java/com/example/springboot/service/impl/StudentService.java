package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.studentLoginDTO;
import com.example.springboot.controller.request.StudentLoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Student;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.service.IStudentService;
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
public class StudentService implements IStudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public studentLoginDTO login(StudentLoginRequest request) {
        Student student = studentMapper.getByStudentNumberAndPassword(request);
        if (student == null){
            throw new ServiceException("用户名或密码错误");
        }
        studentLoginDTO loginDTO = new studentLoginDTO();
        BeanUtils.copyProperties(student, loginDTO);
        return loginDTO;

    }

    @Override
    public void save(Student obj) {

        studentMapper.save(obj);
    }

    @Override
    public void deleteByStudentNumber(Integer studentNumber) {

        studentMapper.deleteByStudentNumber(studentNumber);
    }

    @Override
    public void update(Student obj) {
        obj.setUpdatetime(new Date());
        studentMapper.updateByStudentNumber(obj);
    }

    @Override
    public PageInfo<Student> page(StudentPageRequest studentPageRequest) {
        PageHelper.startPage(studentPageRequest.getPageNum(),studentPageRequest.getPageSize());
        List<Student> students = studentMapper.listByCondition(studentPageRequest);
        return new PageInfo<>(students);
    }

    @Override
    public Student getByStudentNumber(Integer studentNumber) {

        return studentMapper.getByStudentNumber(studentNumber);
    }
}
