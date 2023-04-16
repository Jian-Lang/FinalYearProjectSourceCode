package com.example.springboot.entity;

import com.example.springboot.common.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 数据信息
 * </p>
 *
 * @author Anding
 */
@Data
@ApiModel(value="DatainfoQueryDTO查询对象", description="数据信息查询入参")
public class DatainfoQueryDTO extends BaseQuery {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "文件类型")
    private String type;



}
