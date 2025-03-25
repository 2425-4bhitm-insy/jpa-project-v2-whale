package at.ac.htlleonding.model;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class TrackerId implements Serializable {
    private double lat;
    private double lon;
    private Timestamp timestamp;

    public TrackerId() {
    }

    public TrackerId(double lat, double lon, Timestamp timestamp) {
        this.lat = lat;
        this.lon = lon;
        this.timestamp = timestamp;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrackerId trackerId = (TrackerId) o;
        return Double.compare(lat, trackerId.lat) == 0 && Double.compare(lon, trackerId.lon) == 0 && Objects.equals(timestamp, trackerId.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon, timestamp);
    }
}
