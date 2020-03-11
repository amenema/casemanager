package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "users")
public class Users {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  @Column(name = "u_name")
  private String uName;
 
  @Column(name = "u_passwd")
  private String uPasswd;
 
  @Column(name = "real_name")
  private String realName;
 
  @Column(name = "phone")
  private String phone;
 
  @Column(name = "org_id")
  private long orgId;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
