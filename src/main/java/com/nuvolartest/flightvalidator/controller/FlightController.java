package com.nuvolartest.flightvalidator.controller;


import com.nuvolartest.flightvalidator.model.Flight;
import com.nuvolartest.flightvalidator.service.FlightValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/api")
public class FlightController {

    private final FlightValidationService flightValidationService;

    @Autowired
    public FlightController(FlightValidationService flightValidationService) {
        this.flightValidationService = flightValidationService;
    }

    @PostMapping("/resources")
    public ResponseEntity<Map<String, Object>> validateFlight(@RequestBody Flight flight) {
        // Process the form data here and return a JSON response
        boolean isValid = flightValidationService.isFeasible(flight);

        Map<String, Object> response = new HashMap<>();
        if (isValid) {
            response.put("message", "The flight is valid and feasible.");
        } else {
            response.put("message", "The flight is not feasible.");
        }

        return ResponseEntity.ok(response);
    }

}
