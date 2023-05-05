package com.insigma.datasearch.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class R {
    private Integer code;
    private String message;
    private Object data;

    public static R fail(String message){
        return fail(500,message,null);
    }

    public static R fail(String message,Object data){
        return fail(500,message,data);
    }

    public static R fail(Integer code,String message,Object data){
        return R.builder().code(code).message(message).data(data).build();
    }

    public static R success(String message){
        return success(200,message,null);
    }

    public static R success(String message,Object data){
        return success(200,message,data);
    }

    public static R success(Integer code,String message,Object data){
        return R.builder().code(code).message(message).data(data).build();
    }

}
