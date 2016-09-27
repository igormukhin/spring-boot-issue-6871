package com.example;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Igor Mukhin
 */
@Component("cityService")
@Transactional
class CityService{

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City getCity(String name, String country) {
        Assert.notNull(name, "Name must not be null");
        Assert.notNull(country, "Country must not be null");
        return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
    }

}