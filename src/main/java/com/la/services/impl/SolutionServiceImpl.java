package com.la.services.impl;

import com.la.entitys.Solution;
import com.la.repository.ISolutionRepository;
import com.la.services.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(Solution solution) {
        solutionRepository.save(solution);
    }

    @Override
    public void updated(Solution solution) {
        solutionRepository.save(solution);
    }

    @Override
    public void delete(int id) {
        solutionRepository.deleteById(id);
    }

    @Override
    public List<Solution> list() {
        return solutionRepository.search();
    }
}
