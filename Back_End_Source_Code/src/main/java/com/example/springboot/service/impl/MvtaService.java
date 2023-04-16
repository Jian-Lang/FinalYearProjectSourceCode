package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.*;
import com.example.springboot.controller.request.MvtaPageRequest;
import com.example.springboot.entity.Lab;
import com.example.springboot.entity.Mvta;
import com.example.springboot.mapper.MvtaMapper;
import com.example.springboot.mvta.SSA;
import com.example.springboot.mvta.TaskSelection;
import com.example.springboot.service.IMvtaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MvtaService implements IMvtaService {


    @Autowired
    MvtaMapper mvtaMapper;

    @Override
    public void save_msg(Mvta obj) {

        mvtaMapper.save_msg(obj);

    }


    @Override
    public void save(Mvta obj) {

        mvtaMapper.save(obj);

    }

    @Override
    public DistributionDTO getDistByStudentNumber(Integer studentNumber) {
        // 获取当前同学在数据库中的数据对象
        Mvta mvta = new Mvta();
        mvta = mvtaMapper.getByStudentNumber(studentNumber);

        // 通过这个同学的数据对象，获取到和他同一组的所有同学的数据对象
        List<Mvta> mvtas = mvtaMapper.listByGroupNumber(mvta);
        Mvta mvta1;
        Mvta mvta2;

        // 通过判断，把此次请求的同学命名为mvta1，组内另一名同学命名为mvta2
        if(mvtas.get(0).getStudent_number() == studentNumber){
            mvta1 = mvtas.get(0);
            mvta2 = mvtas.get(1);
        }else{
            mvta1 = mvtas.get(1);
            mvta2 = mvtas.get(0);
        }

        // 获取本次请求同学的所有参数
        int intention1_Of_Student1 = mvta1.getIntention1();
        int intention2_Of_Student1 = mvta1.getIntention2();
        int intention3_Of_Student1 = mvta1.getIntention3();
        int intention4_Of_Student1 = mvta1.getIntention4();
        int intention5_Of_Student1 = mvta1.getIntention5();

        int questionnaire1_Of_Student1 = mvta1.getQuestionnaire1();
        int questionnaire2_Of_Student1 = mvta1.getQuestionnaire2();
        int questionnaire3_Of_Student1 = mvta1.getQuestionnaire3();
        int questionnaire4_Of_Student1 = mvta1.getQuestionnaire4();
        int questionnaire5_Of_Student1 = mvta1.getQuestionnaire5();
        int questionnaire6_Of_Student1 = mvta1.getQuestionnaire6();
        int questionnaire7_Of_Student1 = mvta1.getQuestionnaire7();
        int questionnaire8_Of_Student1 = mvta1.getQuestionnaire8();
        int questionnaire9_Of_Student1 = mvta1.getQuestionnaire9();
        int questionnaire10_Of_Student1 = mvta1.getQuestionnaire10();
        int questionnaire11_Of_Student1 = mvta1.getQuestionnaire11();
        int questionnaire12_Of_Student1 = mvta1.getQuestionnaire12();
        int questionnaire13_Of_Student1 = mvta1.getQuestionnaire13();
        int questionnaire14_Of_Student1 = mvta1.getQuestionnaire14();
        int questionnaire15_Of_Student1 = mvta1.getQuestionnaire15();

        int record1_Of_Student1 = mvta1.getRecord1();
        int record2_Of_Student1 = mvta1.getRecord2();
        int record3_Of_Student1 = mvta1.getRecord3();

        int peer_evaluation_Of_Student1 = mvta1.getPeer_evaluation();

        // 获取组内其他同学的所有参数
        int intention1_Of_Student2 = mvta2.getIntention1();
        int intention2_Of_Student2 = mvta2.getIntention2();
        int intention3_Of_Student2 = mvta2.getIntention3();
        int intention4_Of_Student2 = mvta2.getIntention4();
        int intention5_Of_Student2 = mvta2.getIntention5();

        int questionnaire1_Of_Student2 = mvta2.getQuestionnaire1();
        int questionnaire2_Of_Student2 = mvta2.getQuestionnaire2();
        int questionnaire3_Of_Student2 = mvta2.getQuestionnaire3();
        int questionnaire4_Of_Student2 = mvta2.getQuestionnaire4();
        int questionnaire5_Of_Student2 = mvta2.getQuestionnaire5();
        int questionnaire6_Of_Student2 = mvta2.getQuestionnaire6();
        int questionnaire7_Of_Student2 = mvta2.getQuestionnaire7();
        int questionnaire8_Of_Student2 = mvta2.getQuestionnaire8();
        int questionnaire9_Of_Student2 = mvta2.getQuestionnaire9();
        int questionnaire10_Of_Student2 = mvta2.getQuestionnaire10();
        int questionnaire11_Of_Student2 = mvta2.getQuestionnaire11();
        int questionnaire12_Of_Student2 = mvta2.getQuestionnaire12();
        int questionnaire13_Of_Student2 = mvta2.getQuestionnaire13();
        int questionnaire14_Of_Student2 = mvta2.getQuestionnaire14();
        int questionnaire15_Of_Student2 = mvta2.getQuestionnaire15();

        int record1_Of_Student2 = mvta2.getRecord1();
        int record2_Of_Student2 = mvta2.getRecord2();
        int record3_Of_Student2 = mvta2.getRecord3();

        int peer_evaluation_Of_Student2 = mvta2.getPeer_evaluation();

        // 获取问卷答案
        int ans1 = mvta.getAns1();
        int ans2 = mvta.getAns2();
        int ans3 = mvta.getAns3();
        int ans4 = mvta.getAns4();
        int ans5 = mvta.getAns5();
        int ans6 = mvta.getAns6();
        int ans7 = mvta.getAns7();
        int ans8 = mvta.getAns8();
        int ans9 = mvta.getAns9();
        int ans10 = mvta.getAns10();
        int ans11 = mvta.getAns11();
        int ans12 = mvta.getAns12();
        int ans13 = mvta.getAns13();
        int ans14 = mvta.getAns14();
        int ans15 = mvta.getAns15();

        // 算法区域

        // 变量区域
        int [][] Intention =
        {{intention1_Of_Student1,intention2_Of_Student1,intention3_Of_Student1,
        intention4_Of_Student1,intention5_Of_Student1},
        {intention1_Of_Student2,intention2_Of_Student2,intention3_Of_Student2,
        intention4_Of_Student2,intention5_Of_Student2}};

        int [] PeerEvaluation = {peer_evaluation_Of_Student1, peer_evaluation_Of_Student2};

        int [][] Record = {{record1_Of_Student1, record2_Of_Student1, record3_Of_Student1},
        {record1_Of_Student2, record2_Of_Student2, record3_Of_Student2}};

        int [][] QuestionnaireResults =
        {{questionnaire1_Of_Student1,questionnaire2_Of_Student1,questionnaire3_Of_Student1,
        questionnaire4_Of_Student1,questionnaire5_Of_Student1,questionnaire6_Of_Student1,
        questionnaire7_Of_Student1,questionnaire8_Of_Student1,questionnaire9_Of_Student1,
        questionnaire10_Of_Student1,questionnaire11_Of_Student1,questionnaire12_Of_Student1,
        questionnaire13_Of_Student1,questionnaire14_Of_Student1,questionnaire15_Of_Student1},

        {questionnaire1_Of_Student2,questionnaire2_Of_Student2,questionnaire3_Of_Student2,
        questionnaire4_Of_Student2,questionnaire5_Of_Student2,questionnaire6_Of_Student2,
        questionnaire7_Of_Student2,questionnaire8_Of_Student2,questionnaire9_Of_Student2,
        questionnaire10_Of_Student2,questionnaire11_Of_Student2,questionnaire12_Of_Student2,
        questionnaire13_Of_Student2,questionnaire14_Of_Student2,questionnaire15_Of_Student2}};

        DistributionDTO distributionDTO;
        if(mvta1.getHas_finished_dis() == 0){
            mvta1.setHas_finished_dis(1);
            mvta2.setHas_finished_dis(1);
            int [] QuestionnaireAnswers = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
            int SearchAgentsNum = 10;
            int MaxIteration = 200;
            int Lb = 0;
            int Ub = 1;
            TaskSelection taskSelection = new TaskSelection();
            double [][] MatchDegree = taskSelection.CalculateTaskMatch(Intention);
            double [] Credit = taskSelection.CalculateCredit(PeerEvaluation, Record);
            double [] QuestionnaireScore = taskSelection.QuestionnaireScore(QuestionnaireAnswers, QuestionnaireResults);
            SSA ssa = new SSA(MatchDegree, Credit, QuestionnaireScore);
            double res[][] = ssa.ISSA(SearchAgentsNum, MaxIteration, Lb, Ub, ssa.Model);

            // 算法区域结束

            // 调用算法，获取分配结果
            mvta1.setDistribution1((int) res[0][0]);
            mvta1.setDistribution2((int) res[0][1]);
            mvta1.setDistribution3((int) res[0][2]);
            mvta1.setDistribution4((int) res[0][3]);
            mvta1.setDistribution5((int) res[0][4]);

            mvta2.setDistribution1((int) res[1][0]);
            mvta2.setDistribution2((int) res[1][1]);
            mvta2.setDistribution3((int) res[1][2]);
            mvta2.setDistribution4((int) res[1][3]);
            mvta2.setDistribution5((int) res[1][4]);

            // 保存分配结果到数据库, 注意，此处仅仅插入的是distribution1-5的数据，其他的数据并没有插入进去
            mvtaMapper.save_dist(mvta1);
            mvtaMapper.save_dist(mvta2);

            // 保存distribution后，再次获取数据库对象
            mvta1 = mvtaMapper.getByStudentNumber(studentNumber);

            //  log("姓名: " + name + "intention1: " + mvta.getIntention1());
            distributionDTO = new DistributionDTO();
            BeanUtils.copyProperties(mvta1,distributionDTO);
        }
        else{
            mvta1 = mvtaMapper.getByStudentNumber(studentNumber);

            //  log("姓名: " + name + "intention1: " + mvta.getIntention1());
            distributionDTO = new DistributionDTO();
            BeanUtils.copyProperties(mvta1,distributionDTO);
        }

        return distributionDTO;
    }

    @Override
    public NumberInGroupDTO getNumberInGroupByStudentNumber(Integer studentNumber) {

        NumberInGroupDTO numberInGroupDTO = new NumberInGroupDTO();
        Mvta obj = mvtaMapper.getByStudentNumber(studentNumber);
        int num = mvtaMapper.get_num_in_group_by_student_number(obj);
        numberInGroupDTO.setNumberInGroup(num);
        return numberInGroupDTO;

    }

    @Override
    public FinishedNumberDTO getFinishedNumberByStudentNumber(Integer studentNumber) {

        FinishedNumberDTO finishedNumberDTO= new FinishedNumberDTO();
        Mvta obj = mvtaMapper.getByStudentNumber(studentNumber);
        int num = mvtaMapper.get_finished_num(obj);
        finishedNumberDTO.setFinishedNumber(num);
        return finishedNumberDTO;

    }

    @Override
    public void save_res(Mvta obj) {
        mvtaMapper.save_res(obj);
    }

    @Override
    public void save_dist(Mvta obj) {
        mvtaMapper.save_dist(obj);
    }



    @Override
    public void save_groupNumber(Mvta obj) {
        mvtaMapper.save_groupNumber(obj);
    }

    @Override
    public NumberInGroupDTO getNumberInGroupByGroupNumber(Integer groupNumber) {
        NumberInGroupDTO numberInGroupDTO = new NumberInGroupDTO();

        int num = mvtaMapper.get_num_in_group_by_group_number(groupNumber);
        numberInGroupDTO.setNumberInGroup(num);
        return numberInGroupDTO;
    }

    @Override
    public PageInfo<Mvta> page(MvtaPageRequest mvtaPageRequest) {

        PageHelper.startPage(mvtaPageRequest.getPageNum(),mvtaPageRequest.getPageSize());
        List<Mvta> mvtas = mvtaMapper.listByCondition(mvtaPageRequest);

        return new PageInfo<>(mvtas);
    }
}
