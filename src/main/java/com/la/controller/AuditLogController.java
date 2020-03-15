package com.la.controller;

import com.la.common.ResponseResult;
import com.la.entitys.AuditLog;
import com.la.model.vo.AttachmentInfo;
import com.la.model.vo.AuditLogInfo;
import com.la.services.IAttachmentService;
import com.la.services.IAuditLogService;
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
@RequestMapping("/logs")
public class AuditLogController {

    @Autowired
    private IAuditLogService auditLogService;

    @PostMapping("/list")
    public ResponseResult list(@RequestBody AuditLogInfo auditLogInfo) {
        PageRequest pageRequest = new PageRequest(auditLogInfo.getPageNo(), auditLogInfo.getPageSize());
        return ResponseResult.success(auditLogService.list(auditLogInfo, pageRequest));
    }

}
