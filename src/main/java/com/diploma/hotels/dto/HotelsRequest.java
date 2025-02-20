package com.diploma.hotels.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class HotelsRequest {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkIn;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkOut;
}
