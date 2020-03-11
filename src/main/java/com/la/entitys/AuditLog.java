package com.la.entitys;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author amen
 */
@Data
@Entity
@Table(name = "audit_log")
public class AuditLog {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
 
  @Column(name = "table_name")
  private String tableName;
 
  @Column(name = "row_id")
  private long rowId;
 
  @Column(name = "operator_id")
  private long operatorId;
 
  @Column(name = "operator_type")
  private long operatorType;
 
  @Column(name = "enabled")
  private long enabled;
 
  @Column(name = "update_at")
  private Timestamp updateAt;
 
  @Column(name = "create_at")
  private Timestamp createAt;
 

}
