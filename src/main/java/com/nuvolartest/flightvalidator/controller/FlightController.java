package com.nuvolartest.flightvalidator.controller;


import com.nuvolartest.flightvalidator.model.Flight;
import com.nuvolartest.flightvalidator.service.FlightValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping
public class FlightController {

    private final FlightValidationService flightValidationService;

    @Autowired
    public FlightController(FlightValidationService flightValidationService) {
        this.flightValidationService = flightValidationService;
    }

    @GetMapping("/validate")
    //public @ResponseBody String validateFlight(@RequestBody Flight flight) {
    public @ResponseBody String validateFlight() {
        // Call the FlightValidationService to check if the flight is feasible
        Flight f = new Flight("123X", LocalTime.of(12,12,12),200,100,100,200,200);
        boolean isValid = flightValidationService.isFeasible(f);

        // Return a response based on the validation result
        if (isValid) {
            return "The flight is valid and feasible.";
        } else {
            return "The flight is not feasible.";
        }
    }

}
