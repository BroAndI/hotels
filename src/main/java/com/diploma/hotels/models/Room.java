package com.diploma.hotels.models;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private Integer id;
    private Integer hotelId;
    private Integer roomNumber;
    private Double price;
    private String description;
    private RoomType roomTypes;
    private List<Amenity> amenities;
}
