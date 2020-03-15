package com.la.model.spec;

import com.la.entitys.AuditLog;
import com.la.model.vo.AuditLogInfo;
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
public class TagsSpec implements Specification<AuditLog> {

    private AuditLogInfo auditLogInfo;


    @Override
    public Predicate toPredicate(Root<AuditLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        String tableName = auditLogInfo.getTableName();
        long operatorId = auditLogInfo.getOperatorId();
        long operatorType = auditLogInfo.getOperatorType();
        Timestamp startAt = auditLogInfo.getStartAt();
        Timestamp endAt = auditLogInfo.getEndAt();

        if (StringUtils.isNotBlank(tableName)) {
            Predicate tableNameQ = cb.equal(root.get("tableName").as(String.class), tableName);
            predicates.add(tableNameQ);
        }

        if (ObjectUtils.isNotEmpty(operatorId)) {

            Predicate operatorIdQ = cb.equal(root.get("operatorId").as(Long.class), operatorId);
            predicates.add(operatorIdQ);
        }

        if (ObjectUtils.isNotEmpty(operatorType)) {
            Predicate operatorTypeQ = cb.equal(root.get("operatorType").as(Long.class), operatorType);
            predicates.add(operatorTypeQ);
        }


        if (ObjectUtils.isNotEmpty(startAt)) {
            Predicate startAtQ = cb.greaterThanOrEqualTo(root.get("createdAt").as(Timestamp.class), startAt);
            predicates.add(startAtQ);
        }

        if (ObjectUtils.isNotEmpty(endAt)) {
            Predicate endAtQ = cb.lessThanOrEqualTo(root.get("createdAt").as(Timestamp.class), endAt);
            predicates.add(endAtQ);
        }
        predicates.add(cb.equal(root.get("enabled").as(Boolean.class), true));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
