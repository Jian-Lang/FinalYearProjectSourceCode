package com.example.springboot.mvta;

import java.util.*;

public class SSA {
    int StudentNum = 2;
    int TaskNum = 5;
    double [][] TaskMatch;
    double [] Credit;
    double [] QuestionnaireScore;

    public double [][] Model;

    double [][] Results;

    double ResultFit;
    public SSA(double [][] _TaskMatch, double [] _Credit, double [] _QuestionnaireScore) {
        TaskMatch = _TaskMatch;
        Credit = _Credit;
        QuestionnaireScore = _QuestionnaireScore;
        Model = new double[StudentNum][TaskNum];
        for(int i = 0; i < Model.length; i++) {
            for (int j = 0; j < Model[i].length; j++) {
                Model[i][j] = 0.5 * (TaskMatch[i][j]) + 0.5 * (Credit[i] * 0.5 + QuestionnaireScore[i] * 0.5);
            }
        }
    }

    public void Bounds(double [][] s, double Lb, double Ub){
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < s[i].length; j++){
                if(s[i][j] < Lb){
                    s[i][j] = Lb;
                } else if(s[i][j] > Ub){
                    s[i][j] = Ub;
                }
            }
        }
    }


    public double Func(double [][] Data, double [][] Model){
        double res = 0;
        for(int i = 0; i < Data.length; i++){
            for(int j = 0; j < Data[i].length; j++){
                res += Data[i][j] * Model[i][j];
            }
        }
        return res;
    }

    public int [] ArgSort(double [] Arr){
        int [] res = new int [Arr.length];
        double [] temp = Arr.clone();
        HashMap map = new HashMap();
        for(int i = 0; i < temp.length; i++){
            map.put(temp[i],i);
        }
        Arrays.sort(temp);
        for(int i = 0; i <temp.length; i++){
            res[i] = (int)map.get(temp[i]);
        }
        return res;
    }

    public double [][] Constraint(double [][] Data, double [][] Model){
        double [][] res = Data.clone();
        int MaxTaskNum = TaskNum / StudentNum + 1;
        int [] SelectNum = new int [StudentNum];

        for(int i = 0; i < TaskNum; i++){
            if(Data[0][i] < Data[1][i]){
                if(SelectNum[0] < MaxTaskNum){
                    res[0][i] = 0;
                    res[1][i] = 1;
                    SelectNum[0]++;
                }else {
                    res[0][i] = 1;
                    res[1][i] = 0;
                    SelectNum[1]++;
                }
            }else {
                if(SelectNum[1] < MaxTaskNum){
                    res[0][i] = 1;
                    res[1][i] = 0;
                    SelectNum[1]++;
                }else {
                    res[0][i] = 0;
                    res[1][i] = 1;
                    SelectNum[0]++;
                }
            }
        }

        return res;
    }

    public int MinIndex(double [] Array){
        int res = 0;
        double min = Array[0];
        for(int i = 1; i < Array.length; i++){
            if(min > Array[i]){
                min = Array[i];
                res = i;
            }
        }
        return res;
    }

    public int MaxIndex(double [] Array){
        int res = 0;
        double max = Array[0];
        for(int i = 1; i < Array.length; i++){
            if(max < Array[i]){
                max = Array[i];
                res = i;
            }
        }
        return res;
    }

    public int [] Permuation(int [] Array){
        int [] res = Array.clone();
        Random ramdom = new Random();
        for(int i = 0; i < Array.length; i++){
            int index = ramdom.nextInt(Array.length);
            int temp = res[index];
            res[index] = res[i];
            res[i] = temp;
        }
        return res;
    }

    public double[][] ISSA(int SearchAgentsNum, int MaxIteration, int Lb, int Ub, double [][] Model){
        Results = new double[StudentNum][TaskNum];
        double ResultsFitValue;
        double PPercent = 0.2;      // 探索者比例
        int PNum = (int)Math.round(SearchAgentsNum * PPercent); // 探索者数量
        double APercent = 0.1;
        int ANum = (int)(SearchAgentsNum * APercent); // 警惕者
        double [][][] X =  new double [SearchAgentsNum][StudentNum][TaskNum];
        double [] FitValue = new double[SearchAgentsNum];
        double TentValue = Math.random();
        while(TentValue == 0){
            TentValue = Math.random();
        }
        for(int i = 0; i < SearchAgentsNum; i++) {
            for (int j = 0; j < StudentNum; j++) {
                for (int k = 0; k < TaskNum; k++) {
                    X[i][j][k] = Lb + (Ub - Lb) * TentValue;
                    if (TentValue <= 0.5) {
                        TentValue = 2 * TentValue + Math.random() / MaxIteration;
                    } else if (TentValue > 0.5) {
                        TentValue = 2 * (1 - TentValue) + Math.random() / MaxIteration;
                    }
                    if (TentValue > 1) {
                        TentValue = 1;
                    }
                }
            }
            FitValue[i] = Func(X[i], Model);
        }
        double [] GroubleFitValue = FitValue.clone();
        double [][][] GroubleX = X.clone();

        int BestIndex = MinIndex(FitValue);
        double [][] BestX = X[BestIndex].clone();
        double BestFitValue = FitValue[BestIndex];
        double [][] temp = Constraint(BestX,Model);
        for(int i = 0; i < Results.length; i++){
            for(int j = 0; j < Results[i].length; j++){
                Results[i][j] = temp[i][j];
            }
        }
        ResultsFitValue = Func(Results, Model);

//        System.out.println("适应度：" + ResultsFitValue);
//        System.out.println(Arrays.deepToString(Results));

        for(int i = 0; i < MaxIteration; i++){
            int [] sortIndex = ArgSort(FitValue);
            int WorstIndex = sortIndex[FitValue.length-1];
            double [][] WorstX = new double[StudentNum][TaskNum];
            for(int j = 0; j < WorstX.length; j++){
                for(int k = 0; k < WorstX[j].length; k++){
                    WorstX[j][k] = X[WorstIndex][j][k];
                }
            }
            double w = (Math.exp(2 * (1 - (i + 1.0) / MaxIteration)) - Math.exp(-2 * (1 - (i + 1.0) / MaxIteration))) / (Math.exp(2 * (1 - (i + 1.0) / MaxIteration)) + Math.exp(-2 * (1 - (i+1.0) / MaxIteration)));
            double [][][] P = new double[PNum][StudentNum][TaskNum];
            double [] PFitValue = new double[PNum];
            for(int j = 0; j < PNum; j++){
                P[j] = X[sortIndex[j]];
                PFitValue[j] = FitValue[sortIndex[j]];
            }
            for(int j = 0; j < PNum; j++){
                double r2 = Math.random();
                if(r2 < 0.8){
                    for(int k = 0; k < StudentNum; k++){
                        for(int s = 0; s < TaskNum; s++) {
                            P[j][k][s] += w * Math.random() * (BestX[k][s] - P[j][k][s]);
                        }
                    }
                }else{
//                    double Q = Math.random();
                    for(int k = 0; k < StudentNum; k++){
                        for(int s = 0; s < TaskNum; s++){
                            P[j][k][s] += Math.random();
                        }
                    }
                }
//                P[j] = Constraint(P[j], Model);
                Bounds(P[j], Lb, Ub);
                PFitValue[j] = Func(P[j], Model);
            }

            int PBestIndex = MinIndex(PFitValue);
            double [][] PBestX = P[PBestIndex];

            for(int j = 0; j < SearchAgentsNum - PNum; j++){
                int Index = j + PNum;
                double [][] A = new double[StudentNum][TaskNum];
                for(int k = 0; k < StudentNum; k++){
                    for(int s = 0; s < TaskNum; s++){
                        A[k][s] = Math.floor(Math.random() * 2) * 2 - 1;
                    }
                }
                if(Index > SearchAgentsNum / 2){
                    double Q = Math.random();
                    for(int k = 0; k < StudentNum; k++){
                        for(int s = 0; s < TaskNum; s++){
                            X[sortIndex[Index]][k][s] = Q * Math.exp((WorstX[k][s] - X[sortIndex[Index]][k][s]) / Math.pow(Index,2));
                        }
                    }
                }else {
                    for(int k = 0; k < StudentNum; k++){
                        for(int s = 0; s < TaskNum; s++){
                            X[sortIndex[Index]][k][s] = PBestX[k][s] + Math.abs(X[sortIndex[Index]][k][s] - PBestX[k][s]) * A[k][s] / TaskNum;
                        }
                    }
                }
//                X[sortIndex[Index]] = Constraint(X[sortIndex[Index]], Model);
                Bounds(X[sortIndex[Index]],Lb, Ub);
                FitValue[sortIndex[Index]] = Func(X[sortIndex[Index]], Model);
            }
            int [] Arrc = new int[SearchAgentsNum];
            for(int j = 0; j < Arrc.length; j++){
                Arrc[j] = j;
            }
            int [] AIndex = new int[ANum];
            int [] ATemp = Permuation(Arrc);
            for(int j = 0; j < ANum; j++){
                AIndex[j] = ATemp[j];
            }
            for(int j = 0; j < AIndex.length; j++){
                if(FitValue[sortIndex[AIndex[j]]] != BestFitValue){
                    for(int k = 0; k < StudentNum; k++){
                        for(int s = 0; s < TaskNum; s++){
                            X[sortIndex[AIndex[j]]][k][s] = BestX[k][s] + Math.random() * (X[sortIndex[AIndex[j]]][k][s] - BestX[k][s]);
                        }
                    }
                } else {
                    for(int k = 0; k < StudentNum; k++){
                        for(int s = 0; s < TaskNum; s++){
                            X[sortIndex[AIndex[j]]][k][s] = BestX[k][s] + Math.random() * (WorstX[k][s] - BestX[k][s]);
                        }
                    }
                }
//                X[sortIndex[AIndex[j]]] = Constraint(X[sortIndex[AIndex[j]]], Model);
                Bounds(X[sortIndex[AIndex[j]]], Lb, Ub);
                FitValue[sortIndex[AIndex[j]]] = Func(X[sortIndex[AIndex[j]]], Model);

            }

            for(int j = 0; j < SearchAgentsNum; j++){
                if(FitValue[j] < GroubleFitValue[j]){
                    GroubleX[j] = X[j];
                    GroubleFitValue[j] = FitValue[j];
                }
            }
            double Ps = -Math.pow(Math.exp(1 - (i + 1) / MaxIteration), 20) + 0.05;
            double Ps_Comp = (Math.random() * 2 - 1) * 0.0000009 - 0.95;
            double BestFitValue_Temp = GroubleFitValue[MinIndex(GroubleFitValue)];
            double [][] BestX_Temp = new double [StudentNum][TaskNum];

            if(Ps < Ps_Comp){
                double b = Math.pow((1 - (i+1.0) / MaxIteration), i+1);
                double [][] BestX_Back = new double [StudentNum][TaskNum];
                for(int j = 0; j < StudentNum; j++){
                    for(int k = 0; k < StudentNum; k++){
                        BestX_Back[j][k] = Ub + Math.random() * (Lb - BestX[j][k]);
                        BestX_Temp[j][k] = BestX_Back[j][k] + b * (BestX[j][k] - BestX_Back[j][k]);
                    }
                }
            }else {
                double r = Math.tan((Math.random() - 0.5) * Math.PI);
                for(int j = 0; j < StudentNum; j++){
                    for(int k = 0; k < StudentNum; k++){
                        BestX_Temp[j][k] = (1 + r) * BestX[j][k];
                    }
                }
            }

//            BestX_Temp = Constraint(BestX_Temp, Model);
            Bounds(BestX_Temp,Lb, Ub);
            double Fit_Temp = Func(BestX_Temp, Model);

            if(Fit_Temp < BestFitValue_Temp){
                int Index_Temp = MinIndex(GroubleFitValue);
                GroubleX[Index_Temp] = BestX_Temp;
                GroubleFitValue[Index_Temp] = Fit_Temp;
            }
            if(GroubleFitValue[MinIndex(GroubleFitValue)] < BestFitValue){
                BestIndex = MinIndex(GroubleFitValue);
                BestFitValue = GroubleFitValue[BestIndex];
                BestX = GroubleX[BestIndex];
            }
            for(int j = 0; j < SearchAgentsNum; j++){
                double [][] Temp = Constraint(GroubleX[j],Model);
                if(ResultsFitValue > Func(Temp, Model)){
                    for(int k = 0; k < Results.length; k++){
                        for(int s = 0; s < Results[k].length; s++){
                            Results[k][s] = Temp[k][s];
                        }
                    }
                    ResultsFitValue = Func(Temp, Model);
//                    System.out.println("迭代次数：" + i);
//                    System.out.println("适应度：" + ResultsFitValue);
//                    System.out.println(Arrays.deepToString(Results));
                }
            }
        }

        for(int i = 0; i < StudentNum; i++){
            for(int j = 0; j < TaskNum; j++){
                if(Results[i][j] == 0){
                    Results[i][j] = 1;
                }else if(Results[i][j] == 1){
                    Results[i][j] = 0;
                }
            }
        }
        System.out.println("--------------------- 算法结束 ----------------------");
//        System.out.println("适应度：" + ResultsFitValue);
        System.out.println("结果: " + Arrays.deepToString(Results));
        System.out.println("----------------------------------------------------");
        return Results;
    }

}

