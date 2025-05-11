package com.diploma.hotels.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Embedded
    private Address address;
    private LocalDateTime createdAt;
    @JoinColumn(name = "hotel_id")
    @OneToMany(cascade = {MERGE, PERSIST, DETACH}, orphanRemoval = true)
    private List<Room> rooms;
}
