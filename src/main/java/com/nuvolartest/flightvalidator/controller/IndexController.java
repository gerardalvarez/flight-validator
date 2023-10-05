package com.nuvolartest.flightvalidator.controller;


import com.nuvolartest.flightvalidator.model.Flight;
import com.nuvolartest.flightvalidator.service.FlightValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // This should return the name of your HTML template
    }

}


