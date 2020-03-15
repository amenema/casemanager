package com.la.model.vo;

import com.la.common.nonblank.NonBlank;
import lombok.Data;


/**
 * @author amen
 * @date 2020/3/13 2:32 下午
 */
@Data
public class TagInfo {

    private Long id;

    @NonBlank
    private String industryClass;

    private long parentId;

}
