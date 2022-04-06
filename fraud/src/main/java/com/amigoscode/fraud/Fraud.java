package com.amigoscode.fraud;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Builder;

@Builder
@Entity
@Table(name = "Fraud")
public class Fraud implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @SequenceGenerator(
      name = "fraud_id_sequence",
      sequenceName = "fraud_id_sequence"
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "fraud_id_sequence"
  )
  private Long id;
  private Long customerId;
  private Boolean isFraudster;
  private Date createdAt;

}
