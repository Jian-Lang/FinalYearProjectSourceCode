package com.example.springboot.service;

import com.example.springboot.controller.dto.*;
import com.example.springboot.controller.request.MvtaPageRequest;
import com.example.springboot.entity.Lab;
import com.example.springboot.entity.Mvta;
import com.github.pagehelper.PageInfo;

public interface IMvtaService {
    void save_msg(Mvta obj);

//    List<Integer>

    void save(Mvta obj);

    DistributionDTO getDistByStudentNumber(Integer studentNumber);

    NumberInGroupDTO getNumberInGroupByStudentNumber(Integer studentNumber);

    FinishedNumberDTO getFinishedNumberByStudentNumber(Integer studentNumber);

    void save_res(Mvta obj);

    void save_dist(Mvta obj);



    void save_groupNumber(Mvta mvta);

    NumberInGroupDTO getNumberInGroupByGroupNumber(Integer groupNumber);

    PageInfo<Mvta> page(MvtaPageRequest mvtaPageRequest);
}
