package at.ac.htlleonding.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class WhaleTrackerHistory {

    @EmbeddedId
    private TrackerId trackerId;

    @ManyToOne
    @JoinColumn(name = "whale_id")
    private Whale whale;

    @ManyToOne
    @JoinColumn(name = "ocean_id")
    private Ocean ocean;

    public WhaleTrackerHistory() {
    }

    public WhaleTrackerHistory(double lat, double lon, Timestamp timestamp, Whale whale, Ocean ocean) {
        this.trackerId = new TrackerId(lat, lon, timestamp);
        this.whale = whale;
        this.ocean = ocean;
    }

    public Ocean getOcean() {
        return ocean;
    }

    public void setOcean(Ocean ocean) {
        this.ocean = ocean;
    }

    public Whale getWhale() {
        return whale;
    }

    public void setWhale(Whale whale) {
        this.whale = whale;
    }

    public TrackerId getTrackerId() {
        return trackerId;
    }

}
