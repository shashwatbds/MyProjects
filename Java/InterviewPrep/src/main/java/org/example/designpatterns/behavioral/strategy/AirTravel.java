package org.example.designpatterns.behavioral.strategy;

public class AirTravel implements TransportationStrategy{

    @Override
    public String travelPlan() {
        return "Flight travel";
    }
}
