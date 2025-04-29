package at.ac.htlleonding.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="site")
public class ResearchSite extends ResearchStation {
    @ManyToOne
    @JoinColumn(name = "ocean")
    Ocean ocean;

    public ResearchSite() {
    }

    public ResearchSite(String researchStationName, double lat, double lon, Ocean ocean) {
        super(researchStationName, lat, lon);
        this.ocean = ocean;
    }

}
