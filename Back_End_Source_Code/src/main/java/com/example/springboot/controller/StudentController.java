package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.studentLoginDTO;
import com.example.springboot.controller.request.StudentLoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.entity.Student;
import com.example.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/login")
    public Result login(@RequestBody StudentLoginRequest request){
        studentLoginDTO loginDTO = studentService.login(request);
        return Result.success(loginDTO);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Student obj){

        studentService.save(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{student_number}")
    public Result delete(@PathVariable Integer student_number){
        studentService.deleteByStudentNumber(student_number);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Student obj){

        studentService.update(obj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(StudentPageRequest studentPageRequest){

        return Result.success(studentService.page(studentPageRequest));
    }

    // 按学号获取数据项
    @GetMapping("/{student_number}")
    public Result getByStudentNumber(@PathVariable Integer student_number){
        Student student = studentService.getByStudentNumber(student_number);
        return Result.success(student);
    }


}
