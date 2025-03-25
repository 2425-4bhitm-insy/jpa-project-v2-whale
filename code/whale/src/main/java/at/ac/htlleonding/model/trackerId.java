package at.ac.htlleonding.model;


import jakarta.persistence.Embeddable;

import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class trackerId {
    private double latitude;
    private double longitude;
    private Timestamp timestamp;

    public trackerId() {
    }

    public trackerId(double latitude, double longitude, Timestamp timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        trackerId trackerId = (trackerId) o;
        return Double.compare(latitude, trackerId.latitude) == 0 && Double.compare(longitude, trackerId.longitude) == 0 && Objects.equals(timestamp, trackerId.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, timestamp);
    }
}
