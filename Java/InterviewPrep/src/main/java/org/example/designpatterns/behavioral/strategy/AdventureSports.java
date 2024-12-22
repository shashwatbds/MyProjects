package org.example.designpatterns.behavioral.strategy;

public class AdventureSports implements ActivityStrategy{
    @Override
    public String activityPlan() {
        return "Engage in adventure sports";
    }
}
