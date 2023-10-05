package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.exception.FlightValidationException;
import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeValidationService {

    @Value("${flight.validation.rule2.max-range}")
    private int maxFlightRange;
    @Value("${flight.validation.rule2.afternoon-takeoff-time}")
    private LocalTime afternoonTakeoffTime;
    @Value("${flight.validation.rule2.evening-takeoff-time}")
    private LocalTime eveningTakeoffTime;
    public void validateTakeoffTime(Flight flight) {

        // Implement logic to validate passengers based on the rule 2

        List<String> errorMessages = new ArrayList<>();
        int distance = flight.calculateFlightRange();
        LocalTime takeoff = flight.getTakeoffTime();
        if (takeoff.isAfter(eveningTakeoffTime)){
            errorMessages.add("Exceeded takeoff time limit.");
        }
        if (takeoff.isAfter(afternoonTakeoffTime)) {
            if (distance > maxFlightRange) {
                errorMessages.add("Exceeded maximum flight range after 2 pm.");
            }
        }
        if (!errorMessages.isEmpty()) {
            String errorMessage = String.join("|", errorMessages);
            throw new FlightValidationException(errorMessage);
        }
    }
}
