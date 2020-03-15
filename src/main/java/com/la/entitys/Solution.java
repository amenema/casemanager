package com.la.entitys;


import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "solution")
public class Solution {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "solution_name")
  private String solutionName;
 
  @Column(name = "content")
  private String content;
 
  @Column(name = "industry_class_id")
  private long industryClassId;
 
  @Column(name = "industry_subclass_id")
  private long industrySubclassId;
 
  @Column(name = "target_client")
  private String targetClient;
 
  @Column(name = "partner_id")
  private long partnerId;
 
  @Column(name = "solution_star")
  private long solutionStar;
 
  @Column(name = "collector")
  private String collector;
 
  @Column(name = "attach_id")
  private long attachId;
 
  @Column(name = "example")
  private String example;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
