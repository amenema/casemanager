package com.la.services;


import com.la.entitys.Attachment;
import com.la.model.vo.AttachmentInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface IAttachmentService {
    /**
     *
     * @return
     */
    List<Attachment> list(AttachmentInfo attachmentInfo, Pageable  pageable);

    /**
     *
     * @param id
     * @return
     */
    Attachment detail(Long id);

    /**
     *
     * @param attachmentInfo
     * @return
     */
    AttachmentInfo saveOrUpdate(AttachmentInfo attachmentInfo);

    /**
     *
     * @param id
     */
    void delete(Long id);


}
