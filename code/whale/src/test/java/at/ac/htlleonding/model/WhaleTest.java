package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhaleTest {

    @Test
    public void testWhaleGettersAndSetters() {
        Whale whale = new Whale("Blue Whale");
        WhaleSpecies species = new WhaleSpecies("Balaenoptera musculus");
        ConservationStatus status = new ConservationStatus("Endangered");
        Diet diet = new Diet("Krill");

        whale.setWhaleSpecies(species);
        whale.setConservationStatus(status);
        whale.setDiet(diet);

        assertEquals("Blue Whale", whale.getWhaleName());
        assertEquals(species, whale.getWhaleSpecies());
        assertEquals(status, whale.getConservationStatus());
        assertEquals(diet, whale.getDiet());
    }
}