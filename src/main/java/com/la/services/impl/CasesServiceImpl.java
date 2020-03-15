package com.la.services.impl;

import com.la.entitys.Cases;
import com.la.entitys.Tags;
import com.la.model.spec.CasesSpec;
import com.la.model.vo.CasesInfo;
import com.la.model.vo.TagInfo;
import com.la.repository.ICasesRepository;
import com.la.repository.ITagsRepository;
import com.la.services.ICasesService;
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
public class CasesServiceImpl implements ICasesService {

    @Autowired
    private ICasesRepository casesRepository;

    @Override
    public List<Cases> list(CasesInfo info, Pageable pageable) {
        return casesRepository.list(new CasesSpec(info), pageable);
    }

    @Override
    public Cases detail(long id) {
        return casesRepository.findOne(id);
    }

    @Override
    public CasesInfo saveOrUpdate(CasesInfo casesInfo) {
        Cases cases = new Cases();
        BeanUtils.copyProperties(casesInfo, cases);
        casesRepository.save(cases);
        return casesInfo;
    }

    @Override
    public void delete(Long id) {
        casesRepository.deleteById(id);
    }
}
