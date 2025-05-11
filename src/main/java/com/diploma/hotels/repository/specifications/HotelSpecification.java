package com.diploma.hotels.repository.specifications;

import com.diploma.hotels.domain.Hotel;
import com.diploma.hotels.domain.Reservation;
import com.diploma.hotels.domain.Room;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HotelSpecification {

    public Specification<Hotel> withOverlap(LocalDate checkIn, LocalDate checkOut) {
        return ((root, query, cb) -> {
            Join<Hotel, Room> roomsJoin = root.join("rooms", JoinType.LEFT);
            Join<Room, Reservation> reservations = roomsJoin.join("reservations", JoinType.LEFT);
            reservations.on(cb.and(
                            cb.greaterThan(reservations.get("checkOutDate"), checkIn),
                            cb.lessThan(reservations.get("checkInDate"), checkOut)
                    ));

            return cb.and(cb.isNull(reservations.get("id")));
        });
    }
}
