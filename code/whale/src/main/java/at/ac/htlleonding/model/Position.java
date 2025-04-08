package at.ac.htlleonding.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Position {
    private double lat;
    private double lon;

    public Position() {
    }

    public Position(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }


    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
