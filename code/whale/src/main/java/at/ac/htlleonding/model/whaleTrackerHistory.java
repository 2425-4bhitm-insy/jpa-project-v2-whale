package at.ac.htlleonding.model;

import jakarta.persistence.*;

@Entity
public class whaleTrackerHistory {

    @EmbeddedId
    private trackerId trackerId;

    @ManyToOne
    @JoinColumn(name = "whale_id")
    private Whale whale;

    @ManyToOne
    @JoinColumn(name = "ocean_id")
    Ocean ocean;

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

    public whaleTrackerHistory() {
    }
}
