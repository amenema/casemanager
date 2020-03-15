package com.la.services;

import com.la.entitys.Solution;
import com.la.model.vo.SolutionInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/10 2:05 下午
 */
public interface ISolutionService {

    SolutionInfo saveOrUpdate(SolutionInfo solutionInfo);
    void delete(long id);
    List<Solution> list(SolutionInfo solutionInfo, Pageable pageable);
    Solution detail(long id);


}
