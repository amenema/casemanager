package com.la.services;


import com.la.entitys.Contact;
import com.la.entitys.Tags;
import com.la.model.vo.ContactInfo;
import com.la.model.vo.TagInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface IContactService {
    /**
     *
     * @param type
     * @return
     */
    List<Contact> list(ContactInfo contactInfo, Pageable pageable);

    /**
     *
     * @param id
     * @return
     */
    Contact detail(long id);

    /**
     *
     * @param tagInfo
     * @return
     */
    ContactInfo saveOrUpdate(ContactInfo contactInfo);

    /**
     *
     * @param id
     */
    void delete(Long id);


}
