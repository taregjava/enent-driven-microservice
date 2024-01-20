package com.halfacode.service;

import com.halfacode.dto.CustomerRegistrationRequest;
import com.halfacode.model.Customer;
import com.halfacode.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void  registrationCustomer(CustomerRegistrationRequest registrationRequest){
        Customer customer= Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .gender(registrationRequest.gender())
                .phoneNumber(registrationRequest.phoneNumber())
                .idType(registrationRequest.idType())
                .idValue(registrationRequest.idValue())
                .created(LocalDateTime.now())
                .build();
        customerRepository.save(customer);
        log.info("Customer info {}" , customer);
    }

}
