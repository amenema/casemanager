package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "attachment")
public class Attachment {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "case_id")
  private long caseId;

  @Column(name = "a_name")
  private String aName;

  @Column(name = "a_type")
  private String aType;
 
  @Column(name = "url")
  private String url;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;


}
