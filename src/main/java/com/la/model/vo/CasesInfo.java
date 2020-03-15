package com.la.model.vo;

import lombok.Data;

import java.sql.Timestamp;


/**
 * @author amen
 * @date 2020/3/13 2:32 下午
 */
@Data
public class CasesInfo {

    private long id;

    private String caseName;

    private String city;

    private String county;

    private String client;

    private Timestamp caseTime;

    private double price;

    private String source;

    private String caseType;

    private String content;

    private long partnerId;

    private long solutionId;

    private int pageNo = 1;
    private int pageSize = 10;
}