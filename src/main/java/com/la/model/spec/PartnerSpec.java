package com.la.model.spec;

import com.la.entitys.Partner;
import com.la.model.vo.PartnerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class PartnerSpec implements Specification<Partner> {

    private PartnerInfo partnerInfo;


    @Override
    public Predicate toPredicate(Root<Partner> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        String partnerCorp = partnerInfo.getPartnerCorp();
        String partnerQuali = partnerInfo.getPartnerQuali();
        String partnerAdvan = partnerInfo.getPartnerAdvan();
        String cases = partnerInfo.getCases();
        String collector = partnerInfo.getCollector();


        if (StringUtils.isNotBlank(partnerCorp)) {
            Predicate partnerCorpQ = cb.equal(root.get("partnerCorp").as(String.class), partnerCorp);
            predicates.add(partnerCorpQ);
        }

        if (StringUtils.isNotBlank(partnerQuali)) {
            Predicate partnerQualiQ = cb.equal(root.get("partnerQuali").as(String.class), partnerQuali);
            predicates.add(partnerQualiQ);
        }
        if (StringUtils.isNotBlank(partnerAdvan)) {
            Predicate partnerAdvanQ = cb.equal(root.get("partnerAdvan").as(String.class), partnerAdvan);
            predicates.add(partnerAdvanQ);
        }
        if (StringUtils.isNotBlank(cases)) {
            Predicate casesQ = cb.equal(root.get("cases").as(String.class), cases);
            predicates.add(casesQ);
        }
        if (StringUtils.isNotBlank(collector)) {
            Predicate collectorQ = cb.equal(root.get("collector").as(String.class), collector);
            predicates.add(collectorQ);
        }

        predicates.add(cb.equal(root.get("enabled").as(Boolean.class), true));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
