package com.example.springboot.common;

import lombok.Data;
// 这个Result类，是用来接收service层对数据库查询获得的结果，而后直接将结果给controller层的用户
// 相当于再套娃一层
@Data
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-1";

    private String code;
    private Object data;
    private String msg;
//    注意，下面的函数，通过返回值与类名一致的方法，实现了“静态工厂”方法，这种方法直接返回类的实例化后的对象
//    可以不需要构造函数，就可以对对象进行初始化，并且支持提前自定义初始化的结果，并且可以多种定义
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(msg);
        return result;
    }
}
