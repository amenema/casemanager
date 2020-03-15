package com.la.services.impl;

import com.la.entitys.Contact;
import com.la.entitys.Solution;
import com.la.model.spec.SolutionSpec;
import com.la.model.vo.SolutionInfo;
import com.la.repository.ISolutionRepository;
import com.la.services.ISolutionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/10 2:07 下午
 */
@Service
public class SolutionServiceImpl implements ISolutionService {

    @Autowired
    private ISolutionRepository solutionRepository;

    @Override
    public SolutionInfo saveOrUpdate(SolutionInfo solutionInfo) {
        Solution solution = new Solution();
        BeanUtils.copyProperties(solutionInfo, solution);
        solutionRepository.save(solution);
        return solutionInfo;
    }

    @Override
    public void delete(long id) {
        solutionRepository.deleteById(id);
    }

    @Override
    public List<Solution> list(SolutionInfo info, Pageable pageable) {
        return solutionRepository.search(new SolutionSpec(info), pageable);
    }

    @Override
    public Solution detail(long id) {
        return solutionRepository.findOne(id);
    }
}
