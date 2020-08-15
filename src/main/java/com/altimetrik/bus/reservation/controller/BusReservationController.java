package com.altimetrik.bus.reservation.controller;

import java.util.List;

import com.altimetrik.bus.reservation.entity.BusDetailsEntity;
import com.altimetrik.bus.reservation.entity.BusSearchEntity;
import com.altimetrik.bus.reservation.service.BusReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus")
public class BusReservationController {

    @Autowired
    BusReservationService busReservationService;

    /**
     * getBusById method is for retrieving bus details by Bus ID.
     * 
     * @param {Long} id
     * @return List of BusDetailsEntity
     */
    @GetMapping(value = "/{id}")
    public List<BusDetailsEntity> getBusById(@PathVariable Long id) {
        return busReservationService.getBusById(id);
    }

    /**
     * searchBus method is for filter the bus by search condition and sorting.
     * 
     * @param {BusSearchEntity} busSearchRequest
     * @return List of BusDetailsEntity
     */
    @PostMapping(value = "/search")
    public List<BusDetailsEntity> searchBus(@RequestBody BusSearchEntity busSearchRequest) {
        return busReservationService.searchBus(busSearchRequest);
    }

}