package com.la.model.spec;

import com.la.common.utils.QueryUtils;
import com.la.entitys.Attachment;
import com.la.entitys.AuditLog;
import com.la.model.vo.AttachmentInfo;
import com.la.model.vo.AuditLogInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
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
public class AttachmentSpec implements Specification<Attachment> {

    private AttachmentInfo attachmentInfo;


    @Override
    public Predicate toPredicate(Root<Attachment> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        long caseId = attachmentInfo.getCaseId();
        String aName = attachmentInfo.getAName();
        String aType = attachmentInfo.getAType();


        if (StringUtils.isNotBlank(aName)) {
            Predicate name = cb.like(root.get("aName").as(String.class), QueryUtils.joinLike(aName));
            predicates.add(name);
        }
        if (StringUtils.isNotBlank(aType)) {
            Predicate type = cb.like(root.get("aType").as(String.class), QueryUtils.joinLike(aType));
            predicates.add(type);
        }

        if (ObjectUtils.isNotEmpty(caseId)) {
            Predicate caseIdQ = cb.equal(root.get("caseId").as(Long.class), caseId);
            predicates.add(caseIdQ);
        }

        predicates.add(cb.equal(root.get("enabled").as(Boolean.class), true));
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
