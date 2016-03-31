package com.twair;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    private List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public FlightSearch byCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        List<Flight> flightsWithCapacity = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getPlane().getNumberOfSeats() >= capacity) {
                flightsWithCapacity.add(flight);
            }
        }
        return new FlightSearch(flightsWithCapacity);

    }

    public FlightSearch byLocation(String source, String destination) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        if (source.equals(destination)) {
            throw new IllegalArgumentException("source and destination cannot be same");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }
}
