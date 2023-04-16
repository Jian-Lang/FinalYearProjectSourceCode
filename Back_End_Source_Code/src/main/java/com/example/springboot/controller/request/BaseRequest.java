package com.example.springboot.controller.request;

import lombok.Data;
// 这个类是实现分页效果的公共类，封装了两个成员变量，用来提供给pagehelper
@Data
public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
