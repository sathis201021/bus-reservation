package com.altimetrik.bus.reservation.service;

import java.util.List;

import com.altimetrik.bus.reservation.entity.BusDetailsEntity;
import com.altimetrik.bus.reservation.entity.BusSearchEntity;

public interface BusReservationService {

	public List<BusDetailsEntity> getBusById(Long id);
	
    public List<BusDetailsEntity> searchBus(BusSearchEntity busSearchRequest);
    
}