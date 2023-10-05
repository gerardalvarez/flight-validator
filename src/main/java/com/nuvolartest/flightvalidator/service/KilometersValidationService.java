package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.exception.FlightValidationException;
import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KilometersValidationService {

    @Value("${flight.validation.rule1.max-range}")
    private int maxFlightRange;
    @Value("${flight.validation.rule1.max-passenger-reduced-range}")
    private int maxPassengerReducedRange;
    @Value("${flight.validation.rule1.max-passenger-count}")
    private int maxPassengerCount;
    public void validateMaxKm(Flight flight) {
        List<String> errorMessages = new ArrayList<>();
        int distance = flight.calculateFlightRange();
        if (flight.getNumberOfPassengers() > maxPassengerCount) {
            if (distance > maxPassengerReducedRange) {
                errorMessages.add("Exceeded passenger-reduced range.");
            }
        }
        if (distance > maxFlightRange) {
            errorMessages.add("Exceeded maximum flight range.");
        }

        if (!errorMessages.isEmpty()) {
            String errorMessage = String.join("|", errorMessages);
            throw new FlightValidationException(errorMessage);
        }
    }
}
