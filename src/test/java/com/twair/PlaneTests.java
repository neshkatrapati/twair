package com.twair;
import org.junit.Assert;
import org.junit.Test;

public class PlaneTests {

    @Test
    public void shouldHaveTypeAndCapacity() {
        String type = "testType";
        Integer numSeats = 30;
        Plane plane = new Plane(type, numSeats);
        Assert.assertEquals(type, plane.getType());
        Assert.assertEquals(numSeats, plane.getNumberOfSeats());
    }
}
