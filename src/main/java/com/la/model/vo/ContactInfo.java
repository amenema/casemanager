package com.la.model.vo;

import lombok.Data;


/**
 * @author amen
 * @date 2020/3/13 2:32 下午
 */
@Data
public class ContactInfo {

    private String contactName;

    private String contactRole;

    private String contactPosition;

    private String contactPhone;

    private long partnerId;

    private String partnerOrg;

    private int pageNo = 1;
    private int pageSize = 10;
}