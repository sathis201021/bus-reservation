package com.altimetrik.bus.reservation.util;

/**
 * SortEnum is for sorting by Bus Details.
 */
public enum SortEnum {

    OPERATOR_NAME("OPERATOR_NAME"), DEPARTURE_TIME("DEPARTURE_TIME"), ARRIVAL_TIME("ARRIVAL_TIME"), DURATION("DURATION"), PRICE("PRICE");

    private String sortType;

    SortEnum(String type) {
		this.sortType = type;
	}

    public String getSortType() {
        return sortType;
    }

}