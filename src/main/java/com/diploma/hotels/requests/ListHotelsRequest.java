package com.diploma.hotels.requests;

import java.time.LocalDate;
import java.util.Map;

public record ListHotelsRequest(
        LocalDate checkIn,
        LocalDate checkOut,
        Map<String, Object> hotel,
        Map<String, Object> room
) {}
