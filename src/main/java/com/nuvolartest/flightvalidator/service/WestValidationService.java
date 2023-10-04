package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class WestValidationService {


    @Value("${flight.validation.rule3.max-range}")
    private int maxFlightRange;
    @Value("${flight.validation.rule3.afternoon-takeoff-time}")
    private LocalTime afternoonTakeoffTime;

    public boolean validateWestFlights(Flight flight) {
        // Implement logic to validate passengers based on the rule 3
        if (flight.getDepartureLongitude() < flight.getArrivalLongitude()) return true;
        int distance = flight.calculateFlightRange();
        LocalTime takeoff = flight.getTakeoffTime();
        if (takeoff.isAfter(afternoonTakeoffTime)) return distance <= maxFlightRange;
        else return true;
    }
}
