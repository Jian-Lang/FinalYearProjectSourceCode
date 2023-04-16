package com.example.springboot.mvta;

import cn.hutool.core.lang.Console;
import javafx.geometry.Bounds;

import java.util.Arrays;

import static cn.hutool.core.lang.Console.log;

public class test {


    static int [][] TaskMatch = {{2,1,3,5,4}, {3,4,2,5,1}};
    static int [] ObjectiveValue = {88, 95};
    static int [][] SubjectiveValue = {{83, 86, 92}, {88, 91, 96}};
    static int [][] QuestionnaireResults = {{1,2,3,4,2,2,3,1,4,2,4,1,4,2,2}, {2,1,3,4,2,1,3,2,4,2,3,1,2,3,2}};
    static int [] QuestionnaireAnswers = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    static int SearchAgentsNum = 10;
    static int MaxIteration = 200;
    static int Lb = 0;
    static int Ub = 1;


    public static void main(String[] args) {
        TaskSelection taskSelection = new TaskSelection();
        double [][] MatchDegree = taskSelection.CalculateTaskMatch(TaskMatch);
        double [] Credit = taskSelection.CalculateCredit(ObjectiveValue, SubjectiveValue);
        double [] QuestionnaireScore = taskSelection.QuestionnaireScore(QuestionnaireAnswers, QuestionnaireResults);
        SSA ssa = new SSA(MatchDegree, Credit, QuestionnaireScore);
        double res[][] = ssa.ISSA(SearchAgentsNum, MaxIteration, Lb, Ub, ssa.Model);
//        Console.log(res[0][0]);

    }
}
