package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "partner")
public class Partner {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  @Column(name = "partner_corp")
  private String partnerCorp;
 
  @Column(name = "partner_info")
  private String partnerInfo;
 
  @Column(name = "partner_quali")
  private String partnerQuali;
 
  @Column(name = "partner_advan")
  private String partnerAdvan;
 
  @Column(name = "supered")
  private long supered;
 
  @Column(name = "cases")
  private String cases;
 
  @Column(name = "collector")
  private String collector;
 
  @Column(name = "cmcc")
  private long cmcc;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
