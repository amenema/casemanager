package com.la.controller;

import com.la.common.ResponseResult;
import com.la.services.ISolutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amen
 * @date 2020/3/10 2:13 下午
 */
@Slf4j
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private ISolutionService solutionService;

    @GetMapping("/list")
    public ResponseResult list() {
        return ResponseResult.success(solutionService.list());
    }

}
