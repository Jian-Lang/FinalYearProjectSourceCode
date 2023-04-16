package com.example.springboot.controller;


import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.request.CoursePageRequest;
import com.example.springboot.controller.request.CourseSelectPageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.CourseSelect;
import com.example.springboot.service.ICourseSelectService;
import com.example.springboot.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/courseSelect")
public class CourseSelectController {

    @Autowired
    ICourseSelectService courseSelectService;

    @PostMapping("/save")
    public Result save(@RequestBody CourseSelect obj){

        courseSelectService.save(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{student_number}/{course}")
    public Result delete(@PathVariable Integer student_number, @PathVariable String course){
        courseSelectService.deleteByStudentNumberAndCourse(student_number,course);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(CourseSelectPageRequest courseSelectPageRequest){

        return Result.success(courseSelectService.page(courseSelectPageRequest));
    }

    @GetMapping("/listByTeacherNumber/{teacher_number}")
    public Result listByTeacherNumber(@PathVariable Integer teacher_number){

        return Result.success(courseSelectService.listByTeacherNumber(teacher_number));
    }

    @GetMapping("/countByTeacherNumberAndCourse/{teacher_number}/{course}")
    public Result countByTeacherNumberAndCourse(@PathVariable Integer teacher_number,@PathVariable String course){

        return Result.success(courseSelectService.countByTeacherNumberAndCourse(teacher_number,course));
    }

}
