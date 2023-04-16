package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class MvtaPageRequest extends BaseRequest{

    private Integer student_number;
    private Integer teacher_number;
    private String lab;
    private String course;

}
