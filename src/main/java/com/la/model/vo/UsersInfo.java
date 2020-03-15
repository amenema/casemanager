package com.la.model.vo;

import lombok.Data;


/**
 * @author amen
 * @date 2020/3/13 2:32 下午
 */
@Data
public class UsersInfo {

    private long id;

    private String uName;

    private String realName;

    private String phone;

    private long orgId;

    private int pageNo = 1;

    private int pageSize = 10;
}
