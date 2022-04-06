package com.amigoscode.fraud;

import java.util.Date;
import javax.xml.crypto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudService {
  @Autowired
  private FraudRepository fraudRepository;

  public boolean isFraudlentCustomer(Long customerId) {
      fraudRepository.save(Fraud.builder()
          .customerId(customerId)
          .isFraudster(false)
          .createdAt(new Date())
          .build()
      );
      return false;
  }



}
