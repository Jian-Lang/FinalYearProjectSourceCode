package com.example.springboot.common.res;

/**
 * @Author Anding
 * @Desc
 */
public interface ResultCode {

    /**
     * 成功状态码
     */
    String SUCCESS_STATUS = "200";

    /**
     * 统一失败状态码
     */
    String FAIL_STATUS = "201";

    /**
     * 用户未登录或超时状态码
     */
    String NOT_LOGIN = "301";

    /**
     * 请求参数错误状态码
     */
    String PARAM_ERROR = "202";

    /**
     * 系统内部错误
     */
    String SYSTEM_ERROR = "500";

    /**
     * 登陆错误
     */
    String LOGIN_ERROR = "208";

    /**
     * 新增失败
     */
    String INSERT_FAIL = "20001";

    /**
     * 删除失败
     */
    String DELETE_FAIL = "20002";

    /**
     * 修改失败
     */
    String UPDATE_FAIL = "20003";

    /**
     * 查询失败
     */
    String QUERY_FAIL = "20004";

    /**
     * 查询数据为空
     */
    String QUERY_IS_NULL = "20007";

    /**
     * 用户名或密码错误
     */
    String USERID_USERPASSWORD_FAIL  = "30002";

    /**
     * 用户名密码不能为空
     */
    String USER_NOT_NULL  = "30005";

    /**
     * 权限不够
     */
    String AUTH_NOT_ENOUGH  = "30006";
}
