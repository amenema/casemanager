package com.la.services.impl;

import com.la.entitys.Contact;
import com.la.entitys.Tags;
import com.la.model.spec.ContactSpec;
import com.la.model.vo.ContactInfo;
import com.la.model.vo.TagInfo;
import com.la.repository.IContactRepository;
import com.la.repository.ITagsRepository;
import com.la.services.IContactService;
import com.la.services.ITagsService;
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
public class ContactServiceImpl implements IContactService {
    @Autowired
    private IContactRepository contactRepository;


    @Override
    public List<Contact> list(ContactInfo contactInfo, Pageable pageable) {
        return contactRepository.list(new ContactSpec(contactInfo), pageable);
    }

    @Override
    public Contact detail(long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public ContactInfo saveOrUpdate(ContactInfo contactInfo) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactInfo, contact);
        contactRepository.save(contact);
        return contactInfo;
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
