package com.nuvolartest.flightvalidator.enums;

public enum ValidationRule {


    MAX_KILOMETERS_PASSENGERS("Rule 1: Exceeded passenger-reduced range. With more than 250 passengers the maximum is 8.000 km "),
    MAX_KILOMETERS("Rule 1: Exceeded maximum flight range. The maximum is 12.000 km "),
    FLIGHT_RANGE_TIME("Rule 2: Exceeded maximum flight range after 2 pm. Flights taking off after 2:00 pm can only travel 9.000 km"),
    TAKEOFF_TIME("Rule 2: Exceeded takeoff time limit. There shall be no take-offs after 8:00 pm."),
    WESTBOUND_FLIGHT_RANGE("Rule 3: Exceeded maximum flight range to the west. Flights going West should not travel further than 3.000 km. "),
    WESTBOUND_FLIGHT_TIME("Rule 3: Flights going west must take off before 3 pm.");

    private final String errorMessage;

    ValidationRule(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}