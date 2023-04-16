package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class TeacherPageRequest extends BaseRequest{
    private Integer teacher_number;

    private String teacher_name;
}
