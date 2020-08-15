package com.altimetrik.bus.reservation.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BusSearchEntity {
    private String source;
	private String destination;
	private LocalDate travelDate;
    private LocalDate returnDate;
    private String sortBy;
}