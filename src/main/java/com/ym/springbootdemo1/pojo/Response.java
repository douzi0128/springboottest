package com.ym.springbootdemo1.pojo;

import lombok.Data;

@Data
public class Response {
    private Boolean success;
    private Integer code;
    private String message;
    private Object data;

    public static Response ok(Object data){
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(200);
        response.setMessage("请求成功");
        response.setData(data);
        return response;
    }

    public static Response faild(Object data){
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(1001);
        response.setMessage("请求失败");
        response.setData(data);
        return response;
    }
}
