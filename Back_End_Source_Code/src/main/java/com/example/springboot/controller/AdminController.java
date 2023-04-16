package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.dto.adminLoginDTO;
import com.example.springboot.controller.request.AdminPageRequest;
import com.example.springboot.controller.request.AdminLoginRequest;
import com.example.springboot.entity.Admin;
import com.example.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin  // 解决跨域问题
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody AdminLoginRequest request){
        adminLoginDTO adminLoginDTO = adminService.login(request);
        return Result.success(adminLoginDTO);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Admin obj){

        adminService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin obj){

        adminService.update(obj);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @GetMapping("/list")
    public Result list(){
        List<Admin> list = adminService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest){

        return Result.success(adminService.page(adminPageRequest));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        adminService.deleteById(id);
        return Result.success();
    }
}
