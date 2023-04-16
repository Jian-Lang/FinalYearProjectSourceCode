package com.example.springboot.mapper;

import com.example.springboot.controller.request.MvtaPageRequest;
import com.example.springboot.entity.Mvta;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MvtaMapper {

    // @Select("select * from user") 原始的mybatis访问数据库方法，但不适合大型项目
    void save_msg(Mvta obj);


    void save(Mvta obj);

    Mvta getByStudentNumber(Integer studentNumber);

    List<Mvta> listByGroupNumber(Mvta obj);

    void save_res(Mvta obj);

    void save_dist(Mvta obj);

    int get_num_in_group_by_student_number(Mvta obj);

    int get_finished_num(Mvta obj);



    void save_groupNumber(Mvta obj);

    int get_num_in_group_by_group_number(Integer groupNumber);

    List<Mvta> listByCondition(MvtaPageRequest mvtaPageRequest);
}

