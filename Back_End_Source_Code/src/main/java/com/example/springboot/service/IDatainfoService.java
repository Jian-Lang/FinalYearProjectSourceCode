package com.example.springboot.service;

import com.example.springboot.entity.Datainfo;
import com.example.springboot.entity.DatainfoQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 数据信息 服务类
 * </p>
 *
 * @author Anding
 */
public interface IDatainfoService{

    /**
    * 添加数据信息
    *
    * @param datainfo 数据信息
    * @return int
    * @throws ValidationException
    */
    int insert(Datainfo datainfo) throws ValidationException;

    /**
    * 删除数据信息
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
     * 查询数据信息分页数据
     * @return List<Datainfo>
     */
    List<Datainfo> getList(DatainfoQueryDTO dto) throws ValidationException;


}
