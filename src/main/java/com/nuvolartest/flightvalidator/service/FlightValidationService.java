package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.stereotype.Service;

@Service
public class FlightValidationService {

    public boolean isFeasible(Flight flight) {
        return true;
    }
}
