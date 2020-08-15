package com.altimetrik.bus.reservation.repository;

import java.util.List;

import com.altimetrik.bus.reservation.entity.BusDetailsEntity;
import com.altimetrik.bus.reservation.entity.BusSearchEntity;

import org.springframework.stereotype.Repository;

@Repository
public interface BusReservationRepository {

    public List<BusDetailsEntity> searchBus(BusSearchEntity searchEntity);

    public List<BusDetailsEntity> getBusById(Long busId);
}