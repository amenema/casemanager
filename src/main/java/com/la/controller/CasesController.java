package com.la.controller;

import com.la.common.ResponseResult;
import com.la.model.vo.AttachmentInfo;
import com.la.model.vo.CasesInfo;
import com.la.services.IAttachmentService;
import com.la.services.ICasesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author amen
 * @date 2020/3/13 2:28 下午
 */
@Slf4j
@RestController
@RequestMapping("/cases")
public class CasesController {

    @Autowired
    private ICasesService casesService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody CasesInfo casesInfo) {
        PageRequest pageRequest = new PageRequest(casesInfo.getPageNo(), casesInfo.getPageSize());
        return ResponseResult.success(casesService.list(casesInfo, pageRequest));
    }

    @PostMapping
    public ResponseResult create(@RequestBody CasesInfo info) {
        return ResponseResult.success(casesService.saveOrUpdate(info));
    }

    @GetMapping("/del")
    public ResponseResult delete(@Validated Long id) {
        casesService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult detail(@Validated Long id) {
        return ResponseResult.success(casesService.detail(id));
    }
}
