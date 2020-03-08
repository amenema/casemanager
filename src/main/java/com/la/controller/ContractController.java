package com.la.controller;

import com.la.common.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amen
 * @date 2020/3/8 6:14 下午
 */

@RestController
@RequestMapping("/contract")
public class ContractController {

    @GetMapping("/list")
    public ResponseResult list(){
        return ResponseResult.success("xxxxxx");
    }
}
