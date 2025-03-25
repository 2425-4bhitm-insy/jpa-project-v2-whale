package at.ac.htlleonding.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StationId implements Serializable {

    private double lat;
    private double lon;

    public StationId() {
    }

    public StationId(double lat, double lon) {
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
