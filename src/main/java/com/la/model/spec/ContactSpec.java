package com.la.model.spec;

import com.la.entitys.Contact;
import com.la.model.vo.ContactInfo;
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
public class ContactSpec implements Specification<Contact> {

    private ContactInfo contactInfo;

    @Override
    public Predicate toPredicate(Root<Contact> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        String contactName = contactInfo.getContactName();
        String contactRole = contactInfo.getContactRole();
        String contactPosition = contactInfo.getContactPosition();
        String contactPhone = contactInfo.getContactPhone();
        long partnerId = contactInfo.getPartnerId();
        String partnerOrg = contactInfo.getPartnerOrg();

        if (StringUtils.isNotBlank(contactName)) {
            Predicate contactNameQ = cb.equal(root.get("tableName").as(String.class), contactName);
            predicates.add(contactNameQ);
        }

        if (StringUtils.isNotBlank(contactRole)) {
            Predicate contactRoleQ = cb.equal(root.get("contactRole").as(String.class), contactRole);
            predicates.add(contactRoleQ);
        }
        if (StringUtils.isNotBlank(contactPosition)) {
            Predicate contactPositionQ = cb.equal(root.get("contactPosition").as(String.class), contactPosition);
            predicates.add(contactPositionQ);
        }
        if (StringUtils.isNotBlank(contactPhone)) {
            Predicate contactPhoneQ = cb.equal(root.get("contactPhone").as(String.class), contactPhone);
            predicates.add(contactPhoneQ);
        }

        if (StringUtils.isNotBlank(partnerOrg)) {
            Predicate partnerOrgQ = cb.equal(root.get("partnerOrg").as(String.class), partnerOrg);
            predicates.add(partnerOrgQ);
        }

        if (ObjectUtils.isNotEmpty(contactRole)) {

            Predicate operatorIdQ = cb.equal(root.get("contactRole").as(Long.class), contactRole);
            predicates.add(operatorIdQ);
        }

        if (ObjectUtils.isNotEmpty(partnerId)) {
            Predicate partnerIdQ = cb.equal(root.get("partnerId").as(Long.class), partnerId);
            predicates.add(partnerIdQ);
        }


        predicates.add(cb.equal(root.get("enabled").as(Boolean.class), true));

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
