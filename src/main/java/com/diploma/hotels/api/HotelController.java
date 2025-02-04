package com.diploma.hotels.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @GetMapping
    public String getHotels() {
        return "List of hotels...";
    }

    @GetMapping
    public String getHotel() {
        return "Hotel detail...";
    }
}
