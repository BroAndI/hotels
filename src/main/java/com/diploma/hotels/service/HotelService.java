package com.diploma.hotels.service;

import com.diploma.hotels.mappers.HotelMapper;
import com.diploma.hotels.repository.HotelRepository;
import com.diploma.hotels.repository.dto.HotelListView;
import com.diploma.hotels.repository.dto.HotelView;
import com.diploma.hotels.repository.specifications.HotelSpecification;
import com.diploma.hotels.requests.ListHotelsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelSpecification specification;
    private final HotelMapper hotelMapper;

    public List<HotelListView> findAll(ListHotelsRequest request) {
        return hotelRepository.findAll(specification.construct(request))
                .stream()
                .map(hotelMapper::toListView)
                .toList();
    }

    public List<HotelView> fetchAll(ListHotelsRequest request) {
        return hotelRepository.findAll(specification.construct(request))
                .stream()
                .map(hotelMapper::toHotelView)
                .toList();
    }
}
