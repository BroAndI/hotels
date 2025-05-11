package com.diploma.hotels.repository.dto;

public record HotelListView(
    Long id,
    String name,
    String description,
    String country,
    String city
) {}
