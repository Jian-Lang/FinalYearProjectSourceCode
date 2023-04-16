package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.*;
import com.example.springboot.controller.request.LabPageRequest;
import com.example.springboot.controller.request.MvtaPageRequest;
import com.example.springboot.entity.Mvta;
import com.example.springboot.service.IMvtaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/mvta")
public class MvtaController {

    @Autowired
    IMvtaService mvtaService;


    @PostMapping("/save")
    public Result save(@RequestBody Mvta mvta){

        mvtaService.save(mvta);
        return Result.success();
    }

    @PostMapping("/save_msg")
    public Result save_msg(@RequestBody Mvta mvta){

        mvtaService.save_msg(mvta);
        return Result.success();
    }



    @GetMapping("/get_dist/{studentNumber}")
    public Result getDistByStudentNumber(@PathVariable Integer studentNumber){
        DistributionDTO distributionDTO = mvtaService.getDistByStudentNumber(studentNumber);
        return Result.success(distributionDTO);
    }

    @PostMapping("/save_res")
    public Result save_res(@RequestBody Mvta mvta){

        mvtaService.save_res(mvta);
        return Result.success();
    }

    @PostMapping("/save_group_number")
    public Result save_groupNumber(@RequestBody Mvta mvta){

        mvtaService.save_groupNumber(mvta);
        return Result.success();
    }

    @GetMapping("/get_num_in_group_by_student_number/{studentNumber}")
    public Result getNumberInGroupByStudentNumber(@PathVariable Integer studentNumber){
        NumberInGroupDTO numberInGroupDTO = mvtaService.getNumberInGroupByStudentNumber(studentNumber);

        return Result.success(numberInGroupDTO);
    }

    @GetMapping("/get_num_in_group_by_group_number/{groupNumber}")
    public Result getNumberInGroupByGroupNumber(@PathVariable Integer groupNumber){
        NumberInGroupDTO numberInGroupDTO = mvtaService.getNumberInGroupByGroupNumber(groupNumber);

        return Result.success(numberInGroupDTO);
    }

    @GetMapping("/get_finished_num/{studentNumber}")
    public Result getFinishedNumberByStudentNumber(@PathVariable Integer studentNumber){

        FinishedNumberDTO finishedNumberDTO = mvtaService.getFinishedNumberByStudentNumber(studentNumber);
        return Result.success(finishedNumberDTO);
    }

    @GetMapping("/page")
    public Result page(MvtaPageRequest mvtaPageRequest){

        return Result.success(mvtaService.page(mvtaPageRequest));
    }
}
