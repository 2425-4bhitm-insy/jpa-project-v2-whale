package at.ac.htlleonding.model;

import at.ac.htlleonding.model.WhaleSpecies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhaleSpeciesTest {

    @Test
    public void testWhaleSpeciesGettersAndSetters() {
        WhaleSpecies species = new WhaleSpecies("Humpback Whale");

        assertEquals("Humpback Whale", species.getSpeciesName());

        species.setSpeciesName("Blue Whale");
        assertEquals("Blue Whale", species.getSpeciesName());
    }

    @Test
    public void testWhaleSpeciesConstructor() {
        WhaleSpecies species = new WhaleSpecies("Orca");
        assertEquals("Orca", species.getSpeciesName());
    }
}