package at.ac.htlleonding.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="station_type", discriminatorType = DiscriminatorType.STRING)
public class ResearchStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Position position;

    private String researchStationName;

    public ResearchStation() {
    }

    public ResearchStation(String researchStationName, double lat, double lon) {
        this.researchStationName = researchStationName;
        this.position = new Position(lat, lon);
    }

    public ResearchStation(String researchStationName) {
        this.researchStationName = researchStationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResearchStationName() {
        return researchStationName;
    }

    public void setResearchStationName(String researchStationName) {
        this.researchStationName = researchStationName;
    }

    public Position getPosition() {
        return position;
    }
}
