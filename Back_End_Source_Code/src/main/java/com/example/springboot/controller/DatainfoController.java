package com.example.springboot.controller;

import com.example.springboot.common.res.ResultData;
import com.example.springboot.entity.Datainfo;
import com.example.springboot.entity.DatainfoQueryDTO;
import com.example.springboot.service.IDatainfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 数据信息 前端控制器
 * </p>
 *
 * @author Anding
 */
@Slf4j
@Api(tags = {"数据信息"})
@RestController
@RequestMapping("/datainfo")
public class DatainfoController {

    @Autowired
    private IDatainfoService datainfoService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增数据信息")
    public ResultData insert(@RequestBody Datainfo datainfo){
        ResultData rc = new ResultData();
        try {
            rc.setData(datainfoService.insert(datainfo));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除数据信息")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(datainfoService.delete(id));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询数据信息分页数据")
    public ResultData<PageInfo<Datainfo>> getList(DatainfoQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<Datainfo> list = datainfoService.getList(dto);
            PageInfo<Datainfo> data = new PageInfo<>(list);
            rc.setData(data);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询数据信息所有数据")
    public ResultData<List<Datainfo>> getAll(DatainfoQueryDTO dto){
    ResultData rc = new ResultData();
        try {
            List<Datainfo> list = datainfoService.getList(dto);
            rc.setData(list);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        }
        return rc;
    }

}
