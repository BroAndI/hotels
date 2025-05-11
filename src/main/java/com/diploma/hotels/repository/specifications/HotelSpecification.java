package com.diploma.hotels.repository.specifications;

import com.diploma.hotels.domain.Hotel;
import com.diploma.hotels.domain.Reservation;
import com.diploma.hotels.domain.Room;
import com.diploma.hotels.requests.ListHotelsRequest;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HotelSpecification {

    public Specification<Hotel> construct(ListHotelsRequest request) {
        return ((root, query, cb) -> {
            Join<Hotel, Room> roomsJoin = root.join("rooms", JoinType.LEFT);
            Join<Room, Reservation> reservations = roomsJoin.join("reservations", JoinType.LEFT);
            reservations.on(cb.and(
                            cb.greaterThan(reservations.get("checkOutDate"), request.checkIn()),
                            cb.lessThan(reservations.get("checkInDate"), request.checkOut())
                    ));

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.isNull(reservations.get("id")));
            predicates.addAll(getEquals(cb, root, request.hotel()));
            predicates.addAll(getEquals(cb, roomsJoin, request.room()));

            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

    private List<Predicate> getEquals(CriteriaBuilder cb, Path<?> path, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return Collections.emptyList();
        }

        return params.entrySet().stream()
                .map(entry -> cb.equal(path.get(entry.getKey()), entry.getValue()))
                .toList();
    }
}
