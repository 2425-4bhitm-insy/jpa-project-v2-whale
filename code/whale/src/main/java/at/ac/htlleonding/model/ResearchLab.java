package at.ac.htlleonding.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "lab")
public class ResearchLab extends ResearchStation{
    private String country;
    private String city;

    public ResearchLab() {
    }

    public ResearchLab(String researchStationName, double lat, double lon, String country, String city) {
        super(researchStationName, lat, lon);
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}