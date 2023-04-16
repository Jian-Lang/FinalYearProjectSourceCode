package com.example.springboot.common.res;

/**
 * @Author Anding
 * @Desc
 */
public enum ResultStatus {
    SUCCESS_STATUS(ResultCode.SUCCESS_STATUS, "操作成功"),
    FAIL_STATUS(ResultCode.FAIL_STATUS, "操作失败"),
    NOT_LOGIN(ResultCode.NOT_LOGIN, "用户未登录或超时"),
    PARAM_ERROR(ResultCode.PARAM_ERROR, "请求参数错误"),
    SYSTEM_ERROR(ResultCode.SYSTEM_ERROR, "系统内部错误"),
    LOGIN_ERROR(ResultCode.LOGIN_ERROR, "登录错误"),
    INSERT_FAIL(ResultCode.INSERT_FAIL, "新增失败"),
    DELETE_FAIL(ResultCode.DELETE_FAIL, "删除失败"),
    UPDATE_FAIL(ResultCode.UPDATE_FAIL, "修改失败"),
    QUERY_FAIL(ResultCode.QUERY_FAIL, "查询失败"),
    USERID_USERPASSWORD_FAIL(ResultCode.USERID_USERPASSWORD_FAIL, "用户名或密码错误"),
    QUERY_IS_NULL(ResultCode.QUERY_IS_NULL, "查询数据为空"),
    USER_NOT_NULL(ResultCode.USER_NOT_NULL, "用户名密码不能为空"),
    AUTH_NOT_ENOUGH(ResultCode.AUTH_NOT_ENOUGH, "权限不够"),
    ;


    private String status;
    private String message;

    ResultStatus(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public static String getMessage(String status) {
        for (ResultStatus resultStatus : ResultStatus.values()) {
            if (resultStatus.getStatus().equals(status)) {
                return resultStatus.message;
            }
        }
        return "操作失败！";
    }
}

