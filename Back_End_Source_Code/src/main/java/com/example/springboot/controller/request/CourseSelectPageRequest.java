package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class CourseSelectPageRequest extends BaseRequest{

    private String student_name;
    private Integer student_number;

}
