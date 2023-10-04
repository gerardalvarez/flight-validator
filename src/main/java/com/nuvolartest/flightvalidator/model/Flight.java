package com.nuvolartest.flightvalidator.model;

import com.nuvolartest.flightvalidator.util.Haversine;

import java.time.LocalTime;

public class Flight {

    private String flightNumber;
    private LocalTime takeoffTime;
    private int numberOfPassengers;
    private double departureLatitude;
    private double departureLongitude;
    private double arrivalLatitude;
    private double arrivalLongitude;


    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Flight(String flightNumber, LocalTime takeoffTime, int numberOfPassengers, double departureLatitude, double departureLongitude, double arrivalLatitude, double arrivalLongitude) {
        this.flightNumber = flightNumber;
        this.takeoffTime = takeoffTime;
        this.numberOfPassengers = numberOfPassengers;
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.arrivalLatitude = arrivalLatitude;
        this.arrivalLongitude = arrivalLongitude;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalTime getTakeoffTime() {
        return takeoffTime;
    }

    public void setTakeoffTime(LocalTime takeoffTime) {
        this.takeoffTime = takeoffTime;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public double getDepartureLatitude() {
        return departureLatitude;
    }

    public void setDepartureLatitude(double departureLatitude) {
        this.departureLatitude = departureLatitude;
    }

    public double getDepartureLongitude() {
        return departureLongitude;
    }

    public void setDepartureLongitude(double departureLongitude) {
        this.departureLongitude = departureLongitude;
    }

    public double getArrivalLatitude() {
        return arrivalLatitude;
    }

    public void setArrivalLatitude(double arrivalLatitude) {
        this.arrivalLatitude = arrivalLatitude;
    }

    public double getArrivalLongitude() {
        return arrivalLongitude;
    }

    public void setArrivalLongitude(double arrivalLongitude) {
        this.arrivalLongitude = arrivalLongitude;
    }

    public int calculateFlightRange() {
        double distance = Haversine.getDistance(
                this.getDepartureLatitude(),
                this.getDepartureLongitude(),
                this.getArrivalLatitude(),
                this.getArrivalLongitude()
        );

        return (int) distance; // Assuming flight range is in kilometers
    }


}
