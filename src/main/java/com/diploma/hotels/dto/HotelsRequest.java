package com.diploma.hotels.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HotelsRequest {
    private LocalDate checkIn;
    private LocalDate checkOut;
}
