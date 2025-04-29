package at.ac.htlleonding.model;

import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.ResearchSite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResearchSiteTest {

    @Test
    public void testResearchSiteGettersAndConstructor() {
        Ocean ocean = new Ocean("Atlantic");
        ResearchSite site = new ResearchSite("Site A", 10.0, 20.0, ocean);

        assertEquals("Site A", site.getResearchStationName());
        assertEquals(10.0, site.getPosition().getLat());
        assertEquals(20.0, site.getPosition().getLon());
        assertEquals(ocean, site.ocean);
    }
}