package com.example.springboot.mapper;

import com.example.springboot.controller.dto.QuestionnaireListDTO;
import com.example.springboot.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionnaireMapper {

    void save(Questionnaire questionnaire);

    List<QuestionnaireListDTO> listByTeacherNumberAndCourseAndLab(Integer teacherNumber, String course, String lab);

    void deleteByTeacherNumberAndCourseAndLabAndQuestionnaireName(Integer teacherNumber, String course, String lab, String questionnaireName);

    Questionnaire getByTeacherNumberAndCourseAndLabAndQuestionnaireName(Integer teacherNumber, String course, String lab, String questionnaireName);

    void update(Questionnaire obj);
}
