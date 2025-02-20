package com.diploma.hotels.api;

import com.diploma.hotels.dto.HotelsRequest;
import com.diploma.hotels.models.Hotel;
import com.diploma.hotels.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public String getHotels() {
        return "List of hotels...";
    }

    @GetMapping("/{id}")
    public String getHotel(@PathVariable Integer id) {
        return "Hotel %d detail...".formatted(id);
    }

    @PostMapping
    public List<Hotel> getFreeHotelsController(@RequestBody HotelsRequest request) {
        return hotelService.getHotels(request.getCheckIn(), request.getCheckOut());
    }
}
