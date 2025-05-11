package com.diploma.hotels.service;

import com.diploma.hotels.repository.HotelRepository;
import com.diploma.hotels.repository.dto.HotelListView;
import com.diploma.hotels.repository.specifications.HotelSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelSpecification specification;

    @Transactional
    public List<HotelListView> findAll(LocalDate checkIn, LocalDate checkOut) {
        return hotelRepository.findAll(specification.withOverlap(checkIn, checkOut))
                .stream()
                .map(
                        hotel -> new HotelListView(
                                hotel.getId(),
                                hotel.getName(),
                                hotel.getDescription(),
                                hotel.getAddress().getCountry(),
                                hotel.getAddress().getCity()
                        )
                ).toList();
    }
}
