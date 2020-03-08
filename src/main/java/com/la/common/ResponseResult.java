package com.la.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author amen
 */

@Data
@AllArgsConstructor
public class ResponseResult {
    private String code;
    private String message;
    private Object data;


    public static ResponseResult success() {
        return success(null);
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult("0", "success", data);
    }

    public static ResponseResult error() {
        return error("error");
    }

    public static ResponseResult error(String msg) {
        return new ResponseResult("1", msg, null);
    }
}
