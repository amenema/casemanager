package com.la.repository;

import com.la.entitys.Tags;
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

public interface ITagsRepository extends JpaRepository<Tags, Long> {

    /**
     *
     * @return
     */
    @Query(value = "select * from tags where enabled = 1 and parent_id is null order by id desc ", nativeQuery = true)
    List<Tags> list();

    /**
     *
     * @param parentId
     * @return
     */
    @Query(value = "select * from tags where enabled = 1 and parent_id = ?1 order by id desc ", nativeQuery = true)
    List<Tags> subList(Long parentId);

    @Modifying
    @Query(value = "update tags set enabled = 1 where id = ?1",nativeQuery = true)
    void deleteById(long id);
}
