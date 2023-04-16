package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.QuestionnaireListDTO;
import com.example.springboot.entity.Questionnaire;
import com.example.springboot.mapper.QuestionnaireMapper;
import com.example.springboot.service.IQuestionnaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuestionnaireService implements IQuestionnaireService {

    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @Override
    public void save(Questionnaire questionnaire) {
        questionnaireMapper.save(questionnaire);
    }

    @Override
    public List<QuestionnaireListDTO> listByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab) {
        List <QuestionnaireListDTO> questionnaireListDTOS = questionnaireMapper.listByTeacherNumberAndCourseAndLab(teacherNumber,course,lab);
        return questionnaireListDTOS;
    }

    @Override
    public void deleteByTeacherNumberAndCourseAndLabAndQuestionnaireName(Integer teacherNumber, String course, String lab, String questionnaireName) {
        questionnaireMapper.deleteByTeacherNumberAndCourseAndLabAndQuestionnaireName(teacherNumber,course,lab,questionnaireName);
    }

    @Override
    public Questionnaire getByTeacherNumberAndCourseAndLabAndQuestionnaireName(Integer teacherNumber, String course, String lab, String questionnaireName) {
        return questionnaireMapper.getByTeacherNumberAndCourseAndLabAndQuestionnaireName(teacherNumber,course,lab,questionnaireName);
    }

    @Override
    public void update(Questionnaire obj) {
        questionnaireMapper.update(obj);
    }
}
