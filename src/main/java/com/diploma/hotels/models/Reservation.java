package com.diploma.hotels.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Reservation {
    private Integer id;
    private Long roomId;
    private Timestamp checkIn;
    private Timestamp checkOut;
}
