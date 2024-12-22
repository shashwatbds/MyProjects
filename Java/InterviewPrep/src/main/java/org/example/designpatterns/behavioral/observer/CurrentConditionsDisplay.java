package org.example.designpatterns.behavioral.observer;

public class CurrentConditionsDisplay implements Observer {

    private Subject weatherStation;

    public CurrentConditionsDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Current conditions: "+temp+" F degrees and "+humidity+" pressure"+pressure);
    }
}
