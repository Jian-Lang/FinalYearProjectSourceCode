package com.example.springboot.mvta;

public class TaskSelection {
    int StudentNum = 2;
    int TaskNum = 5;
    public double [] [] CalculateTaskMatch(int [][] StudentIntention){
        double [] [] MatchDegree = new double[StudentNum][TaskNum];
        for(int i = 0; i < StudentNum; i++ ) {
            for(int j =0; j < TaskNum; j++) {
                MatchDegree[i][j] = Math.pow((TaskNum + 1 - StudentIntention[i][j])*1.0/TaskNum, 2);
            }
        }
        return MatchDegree;
    }

    public double [] CalculateCredit(int [] ObjectiveValue, int [] [] SubjectiveValue){
        int CourseNum = 3;
        double [] StudentCredit = new double[StudentNum];
        double [] _SubjectiveValue = new double[StudentNum];
        for(int i = 0; i < StudentNum; i++){
            for(int j = 0; j < CourseNum; j++){
                _SubjectiveValue[i] += SubjectiveValue[i][j];
            }
        }
        for(int i = 0; i < StudentNum; i++) {
            StudentCredit[i] = (((ObjectiveValue[i] + 50) / (CourseNum * 1.0 + 1)) + _SubjectiveValue[i]) / 2 / 100;
        }
        return StudentCredit;
    }

    public double [] QuestionnaireScore(int[] Answers, int [] [] Results){
        int QuestionnaireNum = 15;
        double [] QuestionnaireScore = new double[StudentNum];
        for(int i = 0; i < StudentNum; i++) {
            for(int j = 0; j < QuestionnaireNum; j++){
                if(Results[i][j] == Answers[j]){
                    QuestionnaireScore[i] += 4;
                }
            }
        }
        for(int i = 0; i < StudentNum; i++) {
            QuestionnaireScore[i] /= (QuestionnaireNum * 4);
        }
        return QuestionnaireScore;
    }
}

