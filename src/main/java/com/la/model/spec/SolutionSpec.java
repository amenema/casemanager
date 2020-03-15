package com.la.model.spec;

import com.la.entitys.Solution;
import com.la.model.vo.SolutionInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 3:12 下午
 */
@Data
@AllArgsConstructor
public class SolutionSpec implements Specification<Solution> {

    private SolutionInfo solutionInfo;

    @Override
    public Predicate toPredicate(Root<Solution> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        String content = solutionInfo.getContent();
        String targetClient = solutionInfo.getTargetClient();
        String collector = solutionInfo.getCollector();
        String example = solutionInfo.getExample();
        long industryClassId = solutionInfo.getIndustryClassId();
        long partnerId = solutionInfo.getPartnerId();


        if (StringUtils.isNotBlank(content)) {
            Predicate contentQ = cb.equal(root.get("content").as(String.class), content);
            predicates.add(contentQ);
        }

        if (StringUtils.isNotBlank(targetClient)) {
            Predicate targetClientQ = cb.equal(root.get("targetClient").as(String.class), targetClient);
            predicates.add(targetClientQ);
        }

        if (StringUtils.isNotBlank(collector)) {
            Predicate collectorQ = cb.equal(root.get("collector").as(String.class), collector);
            predicates.add(collectorQ);
        }

        if (StringUtils.isNotBlank(example)) {
            Predicate exampleQ = cb.equal(root.get("example").as(String.class), example);
            predicates.add(exampleQ);
        }

        if (ObjectUtils.isNotEmpty(partnerId)) {
            predicates.add(cb.equal(root.get("partnerId").as(Long.class), partnerId));
        }

        if (ObjectUtils.isNotEmpty(industryClassId)) {
            predicates.add(cb.equal(root.get("industryClassId").as(Long.class), industryClassId));
        }

        predicates.add(cb.equal(root.get("enabled").as(Boolean.class), true));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
