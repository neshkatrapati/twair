package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FlightSearchTests {
    private String source;
    private String destination;
    private FlightSearch allFlights;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        Plane plane1 = new Plane("type1", 10);
        Plane plane2 = new Plane("type1", 3);
        Flight flight1 = new Flight("F001", source, destination, plane1);
        Flight flight2 = new Flight("F002", "TestSource1", destination, plane1);
        Flight flight3 = new Flight("F003", source, destination, plane1);
        Flight flight4 = new Flight("F004", source, destination, plane2);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        allFlights = new FlightSearch(flightList);
    }

    @Test
    public void shouldReturnListOfFlightsForMatchingSourceDestination() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(3, flights.size());
    }

    @Test
    public void shouldReturnListOfFlightsForSingleCapacity() throws Exception {
        List<Flight> flights = allFlights.byCapacity(1).getFlightList();
        Assert.assertEquals(4, flights.size());
    }

    @Test
    public void shouldReturnListOfFlightsForHighCapacity() throws Exception {
        List<Flight> flights = allFlights.byCapacity(7).getFlightList();
        Assert.assertEquals(3, flights.size());
    }


    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource() throws Exception {
        allFlights.byLocation(null, destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty() throws Exception {
        allFlights.byLocation("", destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination() throws Exception {
        allFlights.byLocation(source, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty() throws Exception {
        allFlights.byLocation(source, "");
    }
}
