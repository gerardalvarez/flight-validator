package com.nuvolartest.flightvalidator;

import com.nuvolartest.flightvalidator.enums.ValidationRule;
import com.nuvolartest.flightvalidator.exception.FlightValidationException;
import com.nuvolartest.flightvalidator.model.Flight;
import com.nuvolartest.flightvalidator.service.KilometersValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class KilometersValidationServiceTest {

    @Mock
    private Flight mockFlight;

    @Autowired // Inject the KilometersValidationService bean from the application context
    private KilometersValidationService kilometersValidationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testValidateMaxKmPasses() {
        when(mockFlight.calculateFlightRange()).thenReturn(10); // Mock a flight within limits
        mockFlight.setNumberOfPassengers(200); // Set passengers within limits

        assertDoesNotThrow(() -> kilometersValidationService.validateMaxKm(mockFlight));
    }

    @Test
    void testValidateMaxKmFailsMaxPassengers() {
        when(mockFlight.calculateFlightRange()).thenReturn(11300);
        when(mockFlight.getNumberOfPassengers()).thenReturn(300);// Mock a flight exceeding max range

        FlightValidationException ex = assertThrows(FlightValidationException.class,
                () -> kilometersValidationService.validateMaxKm(mockFlight));

        assertEquals(ValidationRule.MAX_KILOMETERS_PASSENGERS.getErrorMessage(), ex.getMessage());
    }

    @Test
    void testValidateMaxKmFailsMaxRange() {
        when(mockFlight.calculateFlightRange()).thenReturn(13000); // Mock a flight exceeding max range
        mockFlight.setNumberOfPassengers(150); // Set passengers within limits

        FlightValidationException ex = assertThrows(FlightValidationException.class,
                () -> kilometersValidationService.validateMaxKm(mockFlight));

        assertEquals(ValidationRule.MAX_KILOMETERS.getErrorMessage(), ex.getMessage());
    }
}
