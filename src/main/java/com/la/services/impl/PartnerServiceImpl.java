package com.la.services.impl;

import com.la.entitys.Partner;
import com.la.entitys.Tags;
import com.la.model.spec.PartnerSpec;
import com.la.model.vo.PartnerInfo;
import com.la.model.vo.TagInfo;
import com.la.repository.IPartnerRepository;
import com.la.repository.ITagsRepository;
import com.la.services.IPartnerService;
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
public class PartnerServiceImpl implements IPartnerService {

    @Autowired
    private IPartnerRepository partnerRepository;

    @Override
    public List<Partner> list(PartnerInfo info, Pageable pageable) {
        return partnerRepository.list(new PartnerSpec(info), pageable);
    }

    @Override
    public Partner detail(long id) {
        return partnerRepository.findOne(id);
    }

    @Override
    public PartnerInfo saveOrUpdate(PartnerInfo info) {
        Partner partner = new Partner();
        BeanUtils.copyProperties(info, partner);
        return info;
    }

    @Override
    public void delete(Long id) {
        partnerRepository.deleteById(id);
    }
}
