package com.rahul.msscbreweryclient.web.client;

import com.rahul.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Created by Rahul on 12/16/19
 */
@ConfigurationProperties (prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    private String apiHost;
    private final String beerPath = "/beer/api/v1/";

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apiHost + beerPath + "beers/" + beerId, BeerDto.class);
    }

    public BeerDto saveNewBeer(BeerDto newBear) {
        return restTemplate.postForObject(apiHost + beerPath + "beer", newBear, BeerDto.class);
    }

    // @TODO how to get response header and response body both ?    0po
    public URI saveNewBeerForLocation (BeerDto newBeer) {
        return restTemplate.postForLocation(apiHost + beerPath + "beer", newBeer, BeerDto.class);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.put(apiHost + beerPath + "beers/" + beerId, beerDto);
    }

    public void deleteBeer(UUID beerId) {
        restTemplate.delete(apiHost + beerPath + "beers/" + beerId);
    }

}
