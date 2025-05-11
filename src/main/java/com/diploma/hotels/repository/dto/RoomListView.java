package com.diploma.hotels.repository.dto;

import java.math.BigDecimal;

public record RoomListView(
        Long id,
        String roomNumber,
        String roomType,
        BigDecimal price,
        Integer maxGuests
) {}
