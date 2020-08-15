package com.altimetrik.bus.reservation.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.altimetrik.bus.reservation.entity.BusDetailsEntity;
import com.altimetrik.bus.reservation.entity.BusSearchEntity;
import com.altimetrik.bus.reservation.repository.BusReservationRepository;
import com.altimetrik.bus.reservation.service.BusReservationService;
import com.altimetrik.bus.reservation.util.SortEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusReservationServiceImpl implements BusReservationService {

    @Autowired
    private BusReservationRepository repository;

    @Override
    public List<BusDetailsEntity> getBusById(Long busId) {
        return repository.getBusById(busId);
    }

    @Override
    public List<BusDetailsEntity> searchBus(BusSearchEntity busSearchRequest) {
        List<BusDetailsEntity> busDetailsList = repository.searchBus(busSearchRequest);
        String sortByValue = busSearchRequest.getSortBy();
        SortEnum sortBy = SortEnum.valueOf(sortByValue);
        Comparator<BusDetailsEntity> defaultSorting = Comparator.comparingInt(BusDetailsEntity::getPrice);
        switch (sortBy) {
            case OPERATOR_NAME:
                return busDetailsList.stream()
                        .sorted(defaultSorting.thenComparing(Comparator.comparing(BusDetailsEntity::getOperatorName)))
                        .collect(Collectors.toList());

            case DEPARTURE_TIME:
                return busDetailsList.stream()
                        .sorted(defaultSorting.thenComparing(Comparator.comparing(BusDetailsEntity::getDepTime)))
                        .collect(Collectors.toList());

            case ARRIVAL_TIME:
                return busDetailsList.stream()
                        .sorted(defaultSorting.thenComparing(Comparator.comparing(BusDetailsEntity::getArrTime)))
                        .collect(Collectors.toList());

            case DURATION:
                return busDetailsList.stream()
                        .sorted(defaultSorting.thenComparing(Comparator.comparing(BusDetailsEntity::getDuration)))
                        .collect(Collectors.toList());

            default:
                return busDetailsList.stream().sorted(Comparator.comparingInt(BusDetailsEntity::getPrice))
                        .collect(Collectors.toList());

        }
    }

}