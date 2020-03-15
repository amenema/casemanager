package com.la.services;


import com.la.entitys.AuditLog;
import com.la.model.vo.AuditLogInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface IAuditLogService {
    /**
     *
      * @param auditLogInfo
     * @param pageable
     * @return
     */
    List<AuditLog> list(AuditLogInfo auditLogInfo, Pageable pageable);


    /**
     *
     * @param auditLog
     * @return
     */
    void save(AuditLog auditLog);

    void delete(long id);


}
