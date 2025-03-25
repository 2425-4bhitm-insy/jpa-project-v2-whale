package at.ac.htlleonding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WhaleSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long whaleSpeciesId;

    private String speciesName;

    public WhaleSpecies() {
    }

    public WhaleSpecies(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Long getWhaleSpeciesId() {
        return whaleSpeciesId;
    }
}
