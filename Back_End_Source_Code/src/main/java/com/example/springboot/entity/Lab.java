package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Lab {
    private String lab;
    private String course;
    private Integer teacher_number;
    private String teacher_name;
    private Integer num_of_group;
    private Integer size_of_group;
    private Integer is_launched;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;
}
