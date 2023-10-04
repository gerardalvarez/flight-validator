package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeValidationService {

    @Value("${flight.validation.rule2.max-range}")
    private int maxFlightRange;
    @Value("${flight.validation.rule2.afternoon-takeoff-time}")
    private LocalTime afternoonTakeoffTime;
    @Value("${flight.validation.rule2.evening-takeoff-time}")
    private LocalTime eveningTakeoffTime;
    public boolean validateTakeoffTime(Flight flight) {
        // Implement logic to validate passengers based on the rule 2
        int distance = flight.calculateFlightRange();
        LocalTime takeoff = flight.getTakeoffTime();
        if (takeoff.isAfter(eveningTakeoffTime)) return false;
        else if (takeoff.isAfter(afternoonTakeoffTime)) return distance <= maxFlightRange;
        else return true;
    }
}
