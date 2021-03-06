package com.la.controller;

import com.la.common.ResponseResult;
import com.la.model.vo.SolutionInfo;
import com.la.services.ISolutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/list")
    public ResponseResult list(@RequestBody SolutionInfo info) {
        PageRequest pageRequest = new PageRequest(info.getPageNo(), info.getPageSize());
        return ResponseResult.success(solutionService.list(info, pageRequest));
    }

    @PostMapping
    public ResponseResult create(@RequestBody SolutionInfo info) {
        return ResponseResult.success(solutionService.saveOrUpdate(info));
    }

    @GetMapping("/del")
    public ResponseResult delete(@Validated Long id) {
        solutionService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult detail(@Validated Long id) {
        return ResponseResult.success(solutionService.detail(id));
    }

}
