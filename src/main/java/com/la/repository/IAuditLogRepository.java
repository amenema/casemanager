package com.la.repository;

import com.la.entitys.AuditLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/9 1:53 下午
 * 这是一个接口类，命名格式: I${实体类的英文名称}Repository
 * extends 表示继承，这里继承的是JpaRepository<实体类, Long>
 */

public interface IAuditLogRepository extends JpaRepository<AuditLog, Long> {

    /**
     *
     * @param specification
     * @param pageable
     * @return
     */
    List<AuditLog> list(Specification<AuditLog> specification, Pageable pageable);


    @Modifying
    @Query(value = "update audit_log set enabled = 1 where id = ?1",nativeQuery = true)
    void deleteById(long id);
}
