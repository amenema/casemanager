package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "cases")
public class Cases {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  @Column(name = "case_name")
  private String caseName;
 
  @Column(name = "city")
  private String city;
 
  @Column(name = "county")
  private String county;
 
  @Column(name = "client")
  private String client;
 
  @Column(name = "case_time")
  private Timestamp caseTime;
 
  @Column(name = "price")
  private double price;
 
  @Column(name = "source")
  private String source;
 
  @Column(name = "case_type")
  private String caseType;
 
  @Column(name = "content")
  private String content;
 
  @Column(name = "partner_id")
  private long partnerId;
 
  @Column(name = "solution_id")
  private long solutionId;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
