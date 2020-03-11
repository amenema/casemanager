package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "contact")
public class Contact {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  @Column(name = "contact_name")
  private String contactName;
 
  @Column(name = "contact_role")
  private String contactRole;
 
  @Column(name = "contact_position")
  private String contactPosition;
 
  @Column(name = "contact_phone")
  private String contactPhone;
 
  @Column(name = "partner_id")
  private long partnerId;
 
  @Column(name = "partner_org")
  private String partnerOrg;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
