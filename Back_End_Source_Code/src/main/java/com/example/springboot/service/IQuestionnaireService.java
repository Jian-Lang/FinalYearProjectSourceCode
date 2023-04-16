package com.example.springboot.service;

import com.example.springboot.controller.dto.QuestionnaireListDTO;
import com.example.springboot.entity.Questionnaire;

import java.util.List;

public interface IQuestionnaireService {

    void save(Questionnaire questionnaire);

    List<QuestionnaireListDTO> listByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab);

    void deleteByTeacherNumberAndCourseAndLabAndQuestionnaireName(Integer teacherNumber, String course, String lab, String questionnaireName);

    Questionnaire getByTeacherNumberAndCourseAndLabAndQuestionnaireName(Integer teacherNumber, String course, String lab, String questionnaireName);

    void update(Questionnaire obj);
}
