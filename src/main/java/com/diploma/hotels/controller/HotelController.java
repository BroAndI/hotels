package com.diploma.hotels.controller;

import com.diploma.hotels.repository.dto.HotelListView;
import com.diploma.hotels.repository.dto.HotelView;
import com.diploma.hotels.requests.ListHotelsRequest;
import com.diploma.hotels.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping("/list")
    public List<HotelListView> getAll(@RequestBody ListHotelsRequest request) {
        return hotelService.findAll(request);
    }

    @PostMapping("/details")
    public List<HotelView> fetchAll(@RequestBody ListHotelsRequest request) {
        return hotelService.fetchAll(request);
    }
}
