package com.diploma.hotels.domain;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
public class Address {
    private String country;
    private String city;
    private String street;
    private String building;
}
