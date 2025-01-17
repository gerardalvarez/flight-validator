package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.enums.ValidationRule;
import com.nuvolartest.flightvalidator.exception.FlightValidationException;
import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WestValidationService {


    @Value("${flight.validation.rule3.max-range}")
    private int maxFlightRange;
    @Value("${flight.validation.rule3.afternoon-takeoff-time}")
    private LocalTime afternoonTakeoffTime;

    public void validateWestFlights(Flight flight) {
        // Implement logic to validate passengers based on the rule 3
        List<String> errorMessages = new ArrayList<>();
        if (flight.getDepartureLongitude() <= flight.getArrivalLongitude()) return;
        int distance = flight.calculateFlightRange();
        LocalTime takeoff = flight.getTakeoffTime();
        if(takeoff.isAfter(afternoonTakeoffTime)) {
            if (distance > maxFlightRange) {
                errorMessages.add(ValidationRule.WESTBOUND_FLIGHT_RANGE.getErrorMessage());
            }
        } else errorMessages.add(ValidationRule.WESTBOUND_FLIGHT_TIME.getErrorMessage());
        if (!errorMessages.isEmpty()) {
            String errorMessage = String.join("|", errorMessages);
            throw new FlightValidationException(errorMessage);
        }
    }
}
