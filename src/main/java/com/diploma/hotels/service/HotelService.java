package com.diploma.hotels.service;

import com.diploma.hotels.dao.HotelsDAO;
import com.diploma.hotels.models.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelService {
    private final HotelsDAO hotelsDao;

    public List<Hotel> getHotels() {
        return hotelsDao.getHotels();
    }

    public List<Hotel> getHotels(LocalDate checkIn, LocalDate checkOut) {
        return hotelsDao.getFreeHotels(checkIn, checkOut);
    }
}
