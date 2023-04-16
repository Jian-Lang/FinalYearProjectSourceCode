package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class LabPageRequest extends BaseRequest{

    private String course;
    private String lab;
    private Integer teacher_number;
}
