package com.amigoscode.customer;

import com.amigoscode.fraud.FraudCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private RestTemplate restTemplate;

  public void registerCustomer(CustomerRegistrationRequest request){
      Customer customer = Customer.builder()
          .firstName(request.getFirstName())
          .lastName(request.getLastName())
          .email(request.getEmail())
          .build();

      // todo: check if email volid
      // todo: check if email not taken
      customerRepository.saveAndFlush(customer);
      // todo: check if fraudster
      FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
          "http://FRAUD/api/v1/fraud-check/{customerId}",
          FraudCheckResponse.class,
          customer.getId()
      );

      if(fraudCheckResponse.isFraudster()) {
        throw new IllegalStateException("Fraud");
      }
  }

}
