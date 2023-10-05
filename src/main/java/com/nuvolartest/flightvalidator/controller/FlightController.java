package com.nuvolartest.flightvalidator.controller;


import com.nuvolartest.flightvalidator.dto.ValidationResult;
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

    @PostMapping("/validate")
    public @ResponseBody ResponseEntity<Map<String, Object>> validateFlight(@RequestBody Flight flight) {
        ValidationResult validationResult = flightValidationService.isFeasible(flight);
        Map<String, Object> response = new HashMap<>();
        response.put("isValid", validationResult.isValid());
        response.put("errorMessages", validationResult.getErrorMessages());

        return ResponseEntity.ok(response);
    }

}
