package com.rahul.msscbreweryclient.web.client;

import com.rahul.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerByIdTest() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
        System.out.println(customerDto.getCustomerName());
    }

    @Test
    void saveNewCustomerTest() {
        CustomerDto newCustomer = CustomerDto.builder().customerName("Jane Doe")
                .id(UUID.randomUUID())
                .build();
        CustomerDto savedCustomer = customerClient.saveNewCustomer(newCustomer);
        System.out.println(savedCustomer.getCustomerName());
    }

}