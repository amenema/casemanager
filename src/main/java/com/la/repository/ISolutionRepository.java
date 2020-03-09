package com.la.repository;

import com.la.common.nonblank.NonBlank;
import com.la.entitys.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author amen
 * @date 2020/3/9 1:53 下午
 * 这是一个接口类，命名格式: I${实体类的英文名称}Repository
 * extends 表示继承，这里继承的是JpaRepository<实体类, Long>
 */

public interface ISolutionRepository extends JpaRepository<Solution, Long> {

    @Query(value = "select * from solution where enbable = 1  limit 10", nativeQuery = true)
    List<Solution> search();


}
