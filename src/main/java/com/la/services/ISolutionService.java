package com.la.services;

import com.la.common.nonblank.NonBlank;
import com.la.entitys.Solution;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/10 2:05 下午
 */
public interface ISolutionService {

    void save(Solution solution);
    void updated(Solution solution);
    void delete(int id);
    List<Solution> list();


}
