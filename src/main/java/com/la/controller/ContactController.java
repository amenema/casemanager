package com.la.controller;

import com.la.common.ResponseResult;
import com.la.model.vo.AttachmentInfo;
import com.la.model.vo.CasesInfo;
import com.la.model.vo.ContactInfo;
import com.la.services.IAttachmentService;
import com.la.services.ICasesService;
import com.la.services.IContactService;
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
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private IContactService contactService;
    @PostMapping("/list")
    public ResponseResult list(@RequestBody ContactInfo info) {
        PageRequest pageRequest = new PageRequest(info.getPageNo(), info.getPageSize());
        return ResponseResult.success(contactService.list(info, pageRequest));
    }

    @PostMapping
    public ResponseResult create(@RequestBody ContactInfo info) {
        return ResponseResult.success(contactService.saveOrUpdate(info));
    }

    @GetMapping("/del")
    public ResponseResult delete(@Validated Long id) {
        contactService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult detail(@Validated Long id) {
        return ResponseResult.success(contactService.detail(id));
    }
}
