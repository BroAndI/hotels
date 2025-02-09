package com.diploma.hotels.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Hotel {
    private Long id;
    private String name;
    private String description;
    private Double rating;
    private List<Room> roomList;
    private Nutrition nutrition; //TODO change table connections in DB
    private List<Facility> facilities;
}