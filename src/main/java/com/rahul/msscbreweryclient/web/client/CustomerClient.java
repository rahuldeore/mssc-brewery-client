package com.rahul.msscbreweryclient.web.client;

import com.rahul.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * Created by Rahul on 12/18/19
 */
@ConfigurationProperties (prefix = "sfg.customer", ignoreInvalidFields = false)
@Component
public class CustomerClient {

   private String apiHost;
   private String customerPath = "/customer/api/v1/";
   private final RestTemplate restTemplate;

   public void setApiHost(String apiHost) {
      this.apiHost = apiHost;
   }

   public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
      this.restTemplate = restTemplateBuilder.build();
   }

   public CustomerDto getCustomerById(UUID customerId) {
      return restTemplate.getForObject(apiHost + customerPath + "customers/" + customerId, CustomerDto.class);
   }

   public CustomerDto saveNewCustomer(CustomerDto customerDto) {
      return restTemplate.postForObject(apiHost + customerPath + "customer",customerDto,CustomerDto.class);
   }
}
