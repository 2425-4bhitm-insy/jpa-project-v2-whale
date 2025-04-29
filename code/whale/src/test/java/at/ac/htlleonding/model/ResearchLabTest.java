package at.ac.htlleonding.model;

import at.ac.htlleonding.model.ResearchLab;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResearchLabTest {

    @Test
    public void testResearchLabGettersAndConstructor() {
        ResearchLab lab = new ResearchLab("Lab A", 10.0, 20.0, "USA", "New York");

        assertEquals("Lab A", lab.getResearchStationName());
        assertEquals(10.0, lab.getPosition().getLat());
        assertEquals(20.0, lab.getPosition().getLon());
        assertEquals("USA", lab.getCountry());
        assertEquals("New York", lab.getCity());
    }
}