package com.la.model.vo;

import lombok.Data;

/**
 * @author amen
 * @date 2020/3/10 2:17 下午
 */
@Data
public class SolutionInfo {

    private String content;

    private long industryClassId;

    private long industrySubclassId;

    private String targetClient;

    private long partnerId;

    private long solutionStar;

    private String collector;

    private long attachId;

    private String example;

    private int pageNo = 1;
    private int pageSize = 10;
}
