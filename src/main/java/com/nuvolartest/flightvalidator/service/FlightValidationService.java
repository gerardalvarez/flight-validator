package com.nuvolartest.flightvalidator.service;

import com.nuvolartest.flightvalidator.dto.ValidationResult;
import com.nuvolartest.flightvalidator.exception.FlightValidationException;
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


    // Validate without blocking other rules even if errors occur.
    // I follow this approach to ensure that all validation rules are checked, even when some rules imply others
    // allowing us to capture and report multiple issues in a single validation pass. If its

    public ValidationResult isFeasible(Flight flight) {

        ValidationResult result = new ValidationResult(true);

        try {
            kilometersValidationService.validateMaxKm(flight);
        } catch (FlightValidationException ex) {
            result.setValid(false);
            String[] errorMessages = ex.getMessage().split("\\|");
            for (String error : errorMessages) {
                result.addErrorMessage("Rule 1: " + error);
            }
        }

        try {
            timeValidationService.validateTakeoffTime(flight);
        } catch (FlightValidationException ex) {
            result.setValid(false);
            String[] errorMessages = ex.getMessage().split("\\|");
            for (String error : errorMessages) {
                result.addErrorMessage("Rule 2: " + error);
            }
        }

        try {
            westValidationService.validateWestFlights(flight);
        } catch (FlightValidationException ex) {
            result.setValid(false);
            String[] errorMessages = ex.getMessage().split("\\|");
            for (String error : errorMessages) {
                result.addErrorMessage("Rule 3: " + error);
            }
        }

        return result;
    }

}
