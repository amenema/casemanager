package com.la.model.spec;

import com.la.common.utils.QueryUtils;
import com.la.entitys.Cases;
import com.la.model.vo.CasesInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amen
 * @date 2020/3/13 3:12 下午
 */
@Data
@AllArgsConstructor
public class CasesSpec implements Specification<Cases> {

    private CasesInfo casesInfo;


    @Override
    public Predicate toPredicate(Root<Cases> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        String caseName = casesInfo.getCaseName();
        Timestamp caseTime = casesInfo.getCaseTime();
        String caseType = casesInfo.getCaseType();
        String city = casesInfo.getCity();
        String county = casesInfo.getCounty();
        String client = casesInfo.getClient();
        long partnerId = casesInfo.getPartnerId();
        long solutionId = casesInfo.getSolutionId();

        if (StringUtils.isNotBlank(caseName)) {
            Predicate caseNameQ = cb.equal(root.get("caseName").as(String.class), QueryUtils.joinLike(caseName));
            predicates.add(caseNameQ);
        }

        if (StringUtils.isNotBlank(caseType)) {
            Predicate caseTypeQ = cb.equal(root.get("caseType").as(String.class), QueryUtils.joinLike(caseType));
            predicates.add(caseTypeQ);
        }
        if (StringUtils.isNotBlank(city)) {
            Predicate cityQ = cb.equal(root.get("city").as(String.class), QueryUtils.joinLike(city));
            predicates.add(cityQ);
        }
        if (StringUtils.isNotBlank(county)) {
            Predicate countyQ = cb.equal(root.get("county").as(String.class), QueryUtils.joinLike(county));
            predicates.add(countyQ);
        }
        if (StringUtils.isNotBlank(client)) {
            Predicate clientQ = cb.equal(root.get("client").as(String.class), QueryUtils.joinLike(client));
            predicates.add(clientQ);
        }


        if (ObjectUtils.isNotEmpty(solutionId)) {
            Predicate solutionIdQ = cb.equal(root.get("solutionId").as(Long.class), solutionId);
            predicates.add(solutionIdQ);
        }

        if (ObjectUtils.isNotEmpty(partnerId)) {
            Predicate partnerIdQ = cb.equal(root.get("partnerId").as(Long.class), partnerId);
            predicates.add(partnerIdQ);
        }

        predicates.add(cb.equal(root.get("enabled").as(Boolean.class), true));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
