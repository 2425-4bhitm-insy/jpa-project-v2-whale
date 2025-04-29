package at.ac.htlleonding.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class WhaleTrackerHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Position position;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "whale_id")
    private Whale whale;

    @ManyToOne
    @JoinColumn(name = "ocean_id")
    private Ocean ocean;

    public WhaleTrackerHistory() {
    }

    public WhaleTrackerHistory(double lat, double lon, Timestamp timestamp, Whale whale, Ocean ocean) {
        this.whale = whale;
        this.ocean = ocean;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
