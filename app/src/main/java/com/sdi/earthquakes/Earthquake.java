package com.sdi.earthquakes;

public class Earthquake {

    private String id;
    private String place;
    private double magnitude;
    private long time;
    private double loingitude;
    private double latitude;

    public Earthquake(String id, String place, double magnitude, long time, double loingitude, double latitude) {
        this.id = id;
        this.place = place;
        this.magnitude = magnitude;
        this.time = time;
        this.loingitude = loingitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getLoingitude() {
        return loingitude;
    }

    public void setLoingitude(double loingitude) {
        this.loingitude = loingitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
