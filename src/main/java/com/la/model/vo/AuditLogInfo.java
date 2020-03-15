package com.la.model.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author amen
 * @date 2020/3/13 3:15 下午
 */

@Data
public class AuditLogInfo {

    private String tableName;

    private long rowId;

    private long operatorId;

    private long operatorType;

    private Timestamp startAt;

    private Timestamp endAt;

    private int pageNo = 1;
    private int pageSize = 10;
}
