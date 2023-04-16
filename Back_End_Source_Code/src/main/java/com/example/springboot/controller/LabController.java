package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.LabPageRequest;
import com.example.springboot.entity.Lab;
import com.example.springboot.service.ILabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/lab")
public class LabController {
    @Autowired
    ILabService labService;

    @PostMapping("/save")
    public Result save(@RequestBody Lab lab) {

        labService.save(lab);
        return Result.success();
    }

    @DeleteMapping("/delete/{teacher_number}/{course}/{lab}")
    public Result delete(@PathVariable Integer teacher_number, @PathVariable String course, @PathVariable String lab) {
        labService.deleteByTeacherNumberAndCourseAndLab(teacher_number, course, lab);
        return Result.success();
    }

    @PutMapping("/update_size_of_group")
    public Result updateSizeOfGroup(@RequestBody Lab obj){

        labService.updateSizeOfGroup(obj);
        return Result.success();
    }

    @PutMapping("/update_state_of_lab")
    public Result updateStateOfLab(@RequestBody Lab obj){

        labService.updateStateOfLab(obj);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(LabPageRequest labPageRequest){

        return Result.success(labService.page(labPageRequest));
    }

    @GetMapping("/{teacher_number}/{course}/{lab}")
    public Result getByTeacherNumberAndCourseAndLab(@PathVariable Integer teacher_number,@PathVariable String course,@PathVariable String lab){
        Lab labEntity = labService.getByTeacherNumberAndCourseAndLab(teacher_number,course,lab);
        return Result.success(labEntity);
    }

    @GetMapping("/listByTeacherNumberAndCourse/{teacher_number}/{course}")
    public Result listByTeacherNumberAndCourse(@PathVariable Integer teacher_number,@PathVariable String course){

        return Result.success(labService.listByTeacherNumberAndCourse(teacher_number,course));
    }






}
