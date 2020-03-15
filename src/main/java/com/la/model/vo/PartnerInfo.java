package com.la.model.vo;

import lombok.Data;


/**
 * @author amen
 * @date 2020/3/13 2:32 下午
 */
@Data
public class PartnerInfo {

    private long id;

    private String partnerCorp;

    private String partnerInfo;

    private String partnerQuali;

    private String partnerAdvan;

    private long supered;

    private String cases;

    private String collector;

    private long cmcc;

    private int pageNo = 1;
    private int pageSize = 10;
}
