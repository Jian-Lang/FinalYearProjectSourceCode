package com.example.springboot.controller.dto;

import lombok.Data;

@Data
public class adminLoginDTO {
    private Integer id;
    private String username;
    private String phone;
    private String email;
}
