package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResearchStationTest {

    @Test
    public void testResearchStationGettersAndSetters() {
        ResearchStation station = new ResearchStation("Station A", 10.0, 20.0);

        assertEquals("Station A", station.getResearchStationName());
        assertEquals(10.0, station.getPosition().getLat());
        assertEquals(20.0, station.getPosition().getLon());
    }

    @Test
    public void testResearchSite() {
        Ocean ocean = new Ocean("Atlantic");
        ResearchSite site = new ResearchSite("Site A", 10.0, 20.0, ocean);

        assertEquals("Site A", site.getResearchStationName());
        assertEquals(ocean, site.ocean);
    }

    @Test
    public void testResearchLab() {
        ResearchLab lab = new ResearchLab("Lab A", 10.0, 20.0, "USA", "New York");

        assertEquals("Lab A", lab.getResearchStationName());
        assertEquals("USA", lab.getCountry());
        assertEquals("New York", lab.getCity());
    }
}