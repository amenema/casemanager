package com.la.model.vo;

import com.la.common.nonblank.NonBlank;
import lombok.Data;
import lombok.NonNull;

/**
 * @author amen
 * @date 2020/3/13 2:56 下午
 */

@Data
public class AttachmentInfo {

    private long id;

    @NonNull
    private long caseId;

    @NonBlank
    private String aName;

    @NonBlank
    private String aType;

    @NonBlank
    private String url;

    private int pageNo = 1;

    private int pageSize = 10;
}
