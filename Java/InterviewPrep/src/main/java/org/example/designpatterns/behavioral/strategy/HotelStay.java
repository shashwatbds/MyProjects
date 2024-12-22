package org.example.designpatterns.behavioral.strategy;

public class HotelStay implements AccomodationStrategy{
    @Override
    public String stayPlan() {
        return "Stay in hotel";
    }
}
