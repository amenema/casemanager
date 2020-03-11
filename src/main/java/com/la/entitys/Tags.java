package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "tags")
public class Tags {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  @Column(name = "industry_class")
  private String industryClass;
 
  @Column(name = "industry_subclass")
  private String industrySubclass;
 
  @Column(name = "parent_id")
  private long parentId;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
