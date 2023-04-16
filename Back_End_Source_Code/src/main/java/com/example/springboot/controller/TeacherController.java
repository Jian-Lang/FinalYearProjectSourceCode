package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.studentLoginDTO;
import com.example.springboot.controller.dto.teacherLoginDTO;
import com.example.springboot.controller.request.StudentLoginRequest;
import com.example.springboot.controller.request.StudentPageRequest;
import com.example.springboot.controller.request.TeacherLoginRequest;
import com.example.springboot.controller.request.TeacherPageRequest;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.Teacher;
import com.example.springboot.service.IStudentService;
import com.example.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    @PostMapping("/login")
    public Result login(@RequestBody TeacherLoginRequest request){
        teacherLoginDTO loginDTO = teacherService.login(request);
        return Result.success(loginDTO);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Teacher obj){

        teacherService.save(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{teacher_number}")
    public Result delete(@PathVariable Integer teacher_number){
        teacherService.deleteByTeacherNumber(teacher_number);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Teacher obj){

        teacherService.update(obj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(TeacherPageRequest teacherPageRequest){

        return Result.success(teacherService.page(teacherPageRequest));
    }

    // 按学号获取数据项
    @GetMapping("/{teacher_number}")
    public Result getByTeacherNumber(@PathVariable Integer teacher_number){
        Teacher teacher = teacherService.getByTeacherNumber(teacher_number);
        return Result.success(teacher);
    }

}
