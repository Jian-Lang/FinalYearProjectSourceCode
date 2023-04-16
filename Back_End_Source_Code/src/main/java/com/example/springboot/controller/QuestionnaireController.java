package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Questionnaire;
import com.example.springboot.service.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    IQuestionnaireService questionnaireService;
    @PostMapping("/save")
    public Result save(@RequestBody Questionnaire questionnaire) {

        questionnaireService.save(questionnaire);
        return Result.success();
    }

    @GetMapping("/listByTeacherNumberAndCourseAndLab/{teacher_number}/{course}/{lab}")
    public Result listByTeacherNumberAndCourseAndLab(@PathVariable Integer teacher_number,@PathVariable String course,@PathVariable String lab){

        return Result.success(questionnaireService.listByTeacherNumberAndCourseAndLab(teacher_number,course,lab));
    }

    @DeleteMapping("/delete/{teacher_number}/{course}/{lab}/{questionnaire_name}")
    public Result delete(@PathVariable Integer teacher_number, @PathVariable String course, @PathVariable String lab,@PathVariable String questionnaire_name) {
        questionnaireService.deleteByTeacherNumberAndCourseAndLabAndQuestionnaireName(teacher_number, course, lab,questionnaire_name);
        return Result.success();
    }

    @GetMapping("/{teacher_number}/{course}/{lab}/{questionnaire_name}")
    public Result getByTeacherNumberAndCourseAndLabAndQuestionnaireName(@PathVariable Integer teacher_number,@PathVariable String course,@PathVariable String lab,@PathVariable String questionnaire_name){
        Questionnaire questionnaire = questionnaireService.getByTeacherNumberAndCourseAndLabAndQuestionnaireName(teacher_number,course,lab,questionnaire_name);
        return Result.success(questionnaire);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Questionnaire obj){

        questionnaireService.update(obj);
        return Result.success();
    }

}
