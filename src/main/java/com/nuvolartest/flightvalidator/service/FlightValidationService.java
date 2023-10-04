package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightValidationService {
    private final KilometersValidationService kilometersValidationService;
    private final TimeValidationService timeValidationService;
    private final WestValidationService westValidationService;

    @Autowired
    public FlightValidationService(
            KilometersValidationService kilometersValidationService,
            TimeValidationService timeValidationService,
            WestValidationService westValidationService) {
        this.kilometersValidationService = kilometersValidationService;
        this.timeValidationService = timeValidationService;
        this.westValidationService = westValidationService;
    }

    public boolean isFeasible(Flight flight) {

        boolean isKmkValid = kilometersValidationService.validateMaxKm(flight);
        boolean isTimeValid = timeValidationService.validateTakeoffTime(flight);
        boolean isLocationValid = westValidationService.validateWestFlights(flight);

        // Return the final validation result
        return isKmkValid && isTimeValid && isLocationValid;
    }
}
