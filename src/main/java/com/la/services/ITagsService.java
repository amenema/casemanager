package com.la.services;


import com.la.entitys.Tags;
import com.la.model.vo.TagInfo;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface ITagsService {
    /**
     *
     * @param type
     * @return
     */
    List<Tags> list(Long parentId);


    /**
     *
     * @param tagInfo
     * @return
     */
    TagInfo saveOrUpdate(TagInfo tagInfo);

    /**
     *
     * @param id
     */
    void delete(Long id);


}
