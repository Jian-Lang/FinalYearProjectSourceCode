package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.CourseListDTO;
import com.example.springboot.controller.request.CoursePageRequest;
import com.example.springboot.entity.Course;
import com.example.springboot.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/course")
// 搜索，学号，姓名和教师名
public class CourseController {
    @Autowired
    ICourseService courseService;

    @PostMapping("/save")
    public Result save(@RequestBody Course obj){

        courseService.save(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{student_number}/{course}")
    public Result delete(@PathVariable Integer student_number,@PathVariable String course){
        courseService.deleteByStudentNumberAndCourse(student_number,course);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Course obj){

        courseService.update(obj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(CoursePageRequest coursePageRequest){

        return Result.success(courseService.page(coursePageRequest));
    }

    @GetMapping("/{student_number}/{course}")
    public Result getByStudentNumberAndCourse(@PathVariable Integer student_number,@PathVariable String course){
        Course courseEntity = courseService.getByStudentNumberAndCourse(student_number,course);
        return Result.success(courseEntity);
    }


}
