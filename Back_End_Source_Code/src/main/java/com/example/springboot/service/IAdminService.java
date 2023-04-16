package com.example.springboot.service;

import com.example.springboot.controller.dto.adminLoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.AdminLoginRequest;
import com.example.springboot.entity.Admin;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {
    List<Admin> list();

    PageInfo<Admin> page(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);

    void update(Admin obj);

    void deleteById(Integer id);

    adminLoginDTO login(AdminLoginRequest request);
}
