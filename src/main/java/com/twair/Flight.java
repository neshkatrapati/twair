package com.twair;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private String number;

    public Flight(String number, String source, String destination, Plane plane) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
    }

    public Plane getPlane() {return plane;};

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }
}
