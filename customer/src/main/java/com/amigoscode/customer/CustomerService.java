package com.amigoscode.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public void registerCustomer(CustomerRegistrationRequest request){
      Customer customer = Customer.builder()
          .firstName(request.getFirstName())
          .lastName(request.getLastName())
          .email(request.getEmail())
          .build();

      // todo: check if email volid
      // todo: check if email not taken
      customerRepository.save(customer);

  }

}
