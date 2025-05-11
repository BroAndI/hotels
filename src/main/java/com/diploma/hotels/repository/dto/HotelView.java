package com.diploma.hotels.repository.dto;

import com.diploma.hotels.domain.Address;

import java.util.List;

public record HotelView(
        Long id,
        String name,
        String description,
        Address address,
        List<RoomListView> rooms
) {}
