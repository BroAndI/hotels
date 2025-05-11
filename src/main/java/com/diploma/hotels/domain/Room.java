package com.diploma.hotels.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private String roomType;
    private BigDecimal price;
    private Integer maxGuests;
    private LocalDateTime createdAt;
    @JoinColumn(name = "room_id")
    @OneToMany(cascade = {MERGE, PERSIST, DETACH}, orphanRemoval = true)
    private List<Reservation> reservations;
}
