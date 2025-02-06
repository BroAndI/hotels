package com.diploma.hotels.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @GetMapping
    public String getHotels() {
        return "List of hotels...";
    }

    @GetMapping("/{id}")
    public String getHotel(@PathVariable Integer id) {
        return "Hotel %d detail...".formatted(id);
    }
}
