package org.example.designpatterns.behavioral.observer;

public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherStation);
        weatherStation.setMeasurements(30.0f, 80.0f, 30f);
    }
}
