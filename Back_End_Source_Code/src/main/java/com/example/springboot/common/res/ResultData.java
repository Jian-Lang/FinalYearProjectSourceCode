package com.example.springboot.common.res;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @Author Anding
 * @Desc 通用返回结果类
 */
@Data
public class ResultData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 状态
     */
    private String status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;

    public ResultData() {
        this.status = ResultCode.SUCCESS_STATUS;
        this.setMsg(ResultStatus.getMessage(ResultCode.SUCCESS_STATUS));
    }

    public void setError() {
        this.setStatus(ResultCode.SYSTEM_ERROR);
        this.setMsg(ResultStatus.getMessage(ResultCode.SYSTEM_ERROR));
    }

    public void setError(String status) {
        if (StringUtils.isBlank(status)) {
            this.setError();
        } else {
            this.setMsg(ResultStatus.getMessage(status));
            this.setStatus(status);
        }
    }

    public void setErrorMsg(String message) {
        this.setMsg(message);
        this.setStatus(ResultCode.SYSTEM_ERROR);
    }
}
