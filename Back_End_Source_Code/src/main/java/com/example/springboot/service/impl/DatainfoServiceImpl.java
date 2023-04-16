package com.example.springboot.service.impl;

import com.example.springboot.common.res.ResultCode;
import com.example.springboot.entity.Datainfo;
import com.example.springboot.entity.DatainfoQueryDTO;
import com.example.springboot.mapper.DatainfoMapper;
import com.example.springboot.service.IDatainfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 数据信息 服务实现类
 * </p>
 *
 * @author Anding
 */
@Service
public class DatainfoServiceImpl implements IDatainfoService {

    @Resource
    private DatainfoMapper mapper;

    @Override
    public int insert(Datainfo datainfo) throws ValidationException {
        int insert = mapper.insert(datainfo);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(id);
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }


    @Override
    public List<Datainfo> getList(DatainfoQueryDTO dto) throws ValidationException {
        List<Datainfo> lists = mapper.selectList(dto);
        return lists;
    }
}
