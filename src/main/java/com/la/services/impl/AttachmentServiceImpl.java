package com.la.services.impl;

import com.la.entitys.Attachment;
import com.la.model.spec.AttachmentSpec;
import com.la.model.vo.AttachmentInfo;
import com.la.repository.IAttachmentRepository;
import com.la.services.IAttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:28 上午
 */

@Slf4j
@Service
public class AttachmentServiceImpl implements IAttachmentService {

    @Autowired
    private IAttachmentRepository attachmentRepository;

    @Override
    public Attachment detail(Long id) {
        return attachmentRepository.findOne(id);
    }

    @Override
    public List<Attachment> list(AttachmentInfo info, Pageable pageable) {

        return attachmentRepository.list(new AttachmentSpec(info), pageable);
    }

    @Override
    public AttachmentInfo saveOrUpdate(AttachmentInfo attachmentInfo) {
        Attachment attachment = new Attachment();
        BeanUtils.copyProperties(attachmentInfo, attachment);
        attachmentRepository.save(attachment);
        return attachmentInfo;
    }

    @Override
    public void delete(Long id) {

        attachmentRepository.deleteById(id);
    }
}
