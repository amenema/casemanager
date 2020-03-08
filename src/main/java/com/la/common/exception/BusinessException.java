package com.la.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务异常统一处理类
 *
 * @author: amen
 * @date: 2019-08-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private int code;
    private String msg;

    BusinessException(String msg) {
        this.code = 1;
        this.msg = msg;
    }
}
