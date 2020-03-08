package com.la.entitys;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author amen
 * @date 2020/3/8 9:19 下午
 * java 与数据库映射对象
 */
//用来生成get,set,tostring方法
@Data
//表示是一个实体，对应数据库中的表
@Entity
//用来指定表明,默认转换规则，将大写字母转为小写字母，多个单词用下划线分割
@Table(name = "solution")
public class Solution {
    //表示主键
    @Id
    //用来与数据库中的字段做映射
    @Column(name = "id")
    //主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "enable")
    private boolean enable = true;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_at")
    private Date createdAt;
}
