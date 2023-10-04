package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KilometersValidationService {

    @Value("${flight.validation.rule1.max-range}")
    private int maxFlightRange;
    @Value("${flight.validation.rule1.max-passenger-reduced-range}")
    private int maxPassengerReducedRange;
    @Value("${flight.validation.rule1.max-passenger-count}")
    private int maxPassengerCount;
    public boolean validateMaxKm(Flight flight) {
        int distance = flight.calculateFlightRange();
        if (flight.getNumberOfPassengers()> maxPassengerCount){
            return distance <= maxPassengerReducedRange;
        } else return distance <= maxFlightRange;
    }
}
