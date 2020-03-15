package com.la.services;


import com.la.entitys.Partner;
import com.la.model.vo.PartnerInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface IPartnerService {
    /**
     *
     * @param type
     * @return
     */
    List<Partner> list(PartnerInfo info, Pageable pageable);

    /**
     *
     * @param id
     * @return
     */
    Partner detail(long id);

    /**
     *
     * @param tagInfo
     * @return
     */
    PartnerInfo saveOrUpdate(PartnerInfo info);

    /**
     *
     * @param id
     */
    void delete(Long id);



}
