package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.adminLoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.AdminLoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.AdminMapper;
import com.example.springboot.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service

public class AdminService implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> list() {

        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public void save(Admin obj){

        adminMapper.save(obj);
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }

    @Override
    public void update(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.updateById(admin);
    }

    @Override
    public void deleteById(Integer id) {

        adminMapper.deleteById(id);
    }

    @Override
    public adminLoginDTO login(AdminLoginRequest request) {
        Admin admin = adminMapper.getByUsernameAndPassword(request);
        if (admin == null){
            throw new ServiceException("用户名或密码错误");
        }
        adminLoginDTO adminLoginDTO = new adminLoginDTO();
        BeanUtils.copyProperties(admin, adminLoginDTO);
        return adminLoginDTO;

    }


}

