package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class TeacherLoginRequest {

    private Integer teacher_number;
    private String password;

}
