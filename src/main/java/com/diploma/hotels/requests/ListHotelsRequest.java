package com.diploma.hotels.requests;

import java.time.LocalDate;

public record ListHotelsRequest(
        LocalDate checkIn,
        LocalDate checkOut
) {}
