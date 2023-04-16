package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class StudentLoginRequest {
    private Integer student_number;
    private String password;
}
