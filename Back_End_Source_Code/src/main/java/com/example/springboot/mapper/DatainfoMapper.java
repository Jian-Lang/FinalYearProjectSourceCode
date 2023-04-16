package com.example.springboot.mapper;

import com.example.springboot.entity.Datainfo;
import com.example.springboot.entity.DatainfoQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 数据信息 Mapper 接口
 * </p>
 *
 * @author Anding
 *
 */
@Mapper
public interface DatainfoMapper {
    int insert(Datainfo datainfo);
    int delete(String id);
    List<Datainfo> selectList(DatainfoQueryDTO dto);
}
