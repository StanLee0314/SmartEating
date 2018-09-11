package com.example.steven.smarteating.model;

/**
 * Created by steven on 9/11/2018.
 */

public class Location {
    private String name;
    private Double longitude;
    private Double latitude;

    public Location() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Location(String name, Double longitude, Double latitude) {

        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
