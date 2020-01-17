package com.rahul.msscbreweryclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Rahul on 12/16/19
 */
// TODO this is not working yet. Revisit config class concept
@Configuration
public class RestTemplateAutoConfig {

    RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
