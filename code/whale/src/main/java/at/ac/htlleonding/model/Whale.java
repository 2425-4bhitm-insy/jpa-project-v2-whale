package at.ac.htlleonding.model;

import jakarta.persistence.*;

@Entity
public class Whale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long whaleId;

    String whaleName;

    @ManyToOne
    @JoinColumn(name = "whale_species_id")
    private WhaleSpecies whaleSpecies;

    @ManyToOne
    @JoinColumn(name = "conservation_status_id")
    private ConservationStatus conservationStatus;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    public Whale() {
    }

    public Whale(String whaleName) {
        this.whaleName = whaleName;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public ConservationStatus getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(ConservationStatus conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public WhaleSpecies getWhaleSpecies() {
        return whaleSpecies;
    }

    public void setWhaleSpecies(WhaleSpecies whaleSpecies) {
        this.whaleSpecies = whaleSpecies;
    }
}
