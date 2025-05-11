package com.diploma.hotels.mappers;

import com.diploma.hotels.domain.Hotel;
import com.diploma.hotels.repository.dto.HotelListView;
import com.diploma.hotels.repository.dto.HotelView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface HotelMapper {

    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.country", target = "country")
    HotelListView toListView(Hotel hotel);

    HotelView toHotelView(Hotel hotel);
}
