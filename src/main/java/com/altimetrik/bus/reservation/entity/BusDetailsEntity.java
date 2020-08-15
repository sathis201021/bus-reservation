package com.altimetrik.bus.reservation.entity;

import java.time.LocalTime;

import lombok.Data;

@Data
public class BusDetailsEntity {
    private Long busId;
    private String busNo;
    private String operatorName;
	private LocalTime depTime;
	private LocalTime arrTime;
	private float duration;
    private int price;
    private BusSearchEntity searchEntity;
    private Long seatCount;
}