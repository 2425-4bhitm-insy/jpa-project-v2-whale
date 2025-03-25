package at.ac.htlleonding.model;

import jakarta.persistence.*;

@Entity
public class ResearchStation {

    @EmbeddedId
    private StationId stationId;
    private String researchStationName;

    public ResearchStation() {
    }

    public ResearchStation(String researchStationName, double lat, double lon) {
        this.researchStationName = researchStationName;
        this.stationId = new StationId(lat, lon);
    }

    public ResearchStation(String researchStationName) {
        this.researchStationName = researchStationName;
    }


    public String getResearchStationName() {
        return researchStationName;
    }

    public void setResearchStationName(String researchStationName) {
        this.researchStationName = researchStationName;
    }
}
