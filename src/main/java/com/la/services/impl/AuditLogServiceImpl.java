package com.la.services.impl;

import com.la.entitys.AuditLog;
import com.la.model.spec.AuditLogSpec;
import com.la.model.vo.AuditLogInfo;
import com.la.repository.IAuditLogRepository;
import com.la.services.IAuditLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:28 上午
 */

@Slf4j
@Service
public class AuditLogServiceImpl implements IAuditLogService {

    @Autowired
    private IAuditLogRepository auditLogRepository;

    @Override
    public List<AuditLog> list(AuditLogInfo auditLogInfo, Pageable pageable) {
        AuditLogSpec auditLogSpec = new AuditLogSpec(auditLogInfo);
        return auditLogRepository.list(auditLogSpec, pageable);
    }

    @Override
    public void save(AuditLog auditLog) {
        auditLogRepository.save(auditLog);
    }

    @Override
    public void delete(long id) {
        auditLogRepository.deleteById(id);
    }
}
