package com.rahul.msscbreweryclient.web.client;

import com.rahul.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
        if (beerDto != null) {
            System.out.println(beerDto.getId());
            System.out.println(beerDto.getBeerName());
            System.out.println(beerDto.getBeerStyle());
        }
    }

    @Test
    void saveNewBeer() {
        BeerDto newBeer = BeerDto.builder().beerName("Miller Lite")
                .beerStyle("Light Wit Bier")
                .build();
        BeerDto savedBeer = breweryClient.saveNewBeer(newBeer);
        assertNotNull(savedBeer);
        System.out.println(savedBeer.getId() + "\n" + savedBeer.getBeerName());
    }

    @Test
    void updateBeerTest() {
        BeerDto beerDto = BeerDto.builder().beerName("Paul Aner")
                .beerStyle("German")
                .build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeerTest() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}