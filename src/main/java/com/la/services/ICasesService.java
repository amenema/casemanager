package com.la.services;


import com.la.entitys.Cases;
import com.la.entitys.Tags;
import com.la.model.vo.CasesInfo;
import com.la.model.vo.TagInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 11:26 上午
 */
public interface ICasesService {
    /**
     *
     * @param type
     * @return
     */
    List<Cases> list(CasesInfo info, Pageable pageable);

    /**
     *
     * @param id
     * @return
     */
    Cases detail(long id);

    /**
     *
     * @param tagInfo
     * @return
     */
    CasesInfo saveOrUpdate(CasesInfo casesInfo);

    /**
     *
     * @param id
     */
    void delete(Long id);


}
