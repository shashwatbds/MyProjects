package org.example.designpatterns.behavioral.strategy;

public class TravelPlan {

    private TransportationStrategy transportationStrategy;
    private AccomodationStrategy accomodationStrategy;
    private ActivityStrategy activityStrategy;

    public void setTransportationStrategy(TransportationStrategy transportationStrategy) {
        this.transportationStrategy = transportationStrategy;
    }

    public void setAccomodationStrategy(AccomodationStrategy accomodationStrategy) {
        this.accomodationStrategy = accomodationStrategy;
    }

    public void setActivityStrategy(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    public String generatePlan() {
        return transportationStrategy.travelPlan()+" and "+accomodationStrategy.stayPlan()+" then "+activityStrategy.activityPlan();
    }

    public static void main(String[] args) {
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setAccomodationStrategy(new HotelStay());
        travelPlan.setTransportationStrategy(new AirTravel());
        travelPlan.setActivityStrategy(new AdventureSports());

        System.out.println(travelPlan.generatePlan());
    }
}
