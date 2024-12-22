package org.example.bean;

public class Address {

    private int houseNumber;
    private String city;

    public Address(int houseNumber, String city) {
        this.city = city;
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", city='" + city + '\'' +
                '}';
    }
}
