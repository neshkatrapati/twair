package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        plane = new Plane("type", 30);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDestination());
    }
}
