package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class StudentPageRequest extends BaseRequest{

    private Integer student_number;

    private String student_name;
}
