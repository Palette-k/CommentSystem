package com.gdufe.cs.dto;

import com.gdufe.cs.exception.CustomizeErrorCode;
import com.gdufe.cs.exception.CustomizeException;
import lombok.Data;

/**
 * @Author: wzq
 * @Description: TODO
 * @DateTime: 2022/3/20 10:19
 **/
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    protected static <T> ResultDTO<T> build(T data) {
        ResultDTO<T> result = new ResultDTO<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> ResultDTO<T> build(T body, CustomizeErrorCode resultCodeEnum) {
        ResultDTO<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> ResultDTO<T> build(Integer code, String message) {
        ResultDTO<T> result = build(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static ResultDTO error(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO error(CustomizeErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO error(CustomizeException e) {
        return error(e.getCode(), e.getMessage());
    }

    public static ResultDTO ok() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }



    public static <T> ResultDTO ok(T t) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }
}
