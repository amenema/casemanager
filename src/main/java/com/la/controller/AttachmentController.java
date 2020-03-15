package com.la.controller;

import com.la.common.ResponseResult;
import com.la.entitys.Attachment;
import com.la.model.vo.AttachmentInfo;
import com.la.model.vo.TagInfo;
import com.la.services.IAttachmentService;
import com.la.services.ITagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author amen
 * @date 2020/3/13 2:28 下午
 */
@Slf4j
@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private IAttachmentService attachmentService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody AttachmentInfo attachment) {
        PageRequest pageRequest = new PageRequest(attachment.getPageNo(), attachment.getPageSize());
        return ResponseResult.success(attachmentService.list(attachment, pageRequest));
    }

    @PostMapping
    public ResponseResult create(@RequestBody AttachmentInfo attachmentInfo) {
        return ResponseResult.success(attachmentService.saveOrUpdate(attachmentInfo));
    }

    @GetMapping("/del")
    public ResponseResult delete(@Validated Long id) {
        attachmentService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult detail(@Validated Long id) {
        return ResponseResult.success(attachmentService.detail(id));
    }
}
