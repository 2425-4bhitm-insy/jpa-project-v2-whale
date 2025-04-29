package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OceanTest {

    @Test
    public void testOceanGettersAndSetters() {
        Ocean ocean = new Ocean("Pacific");

        assertEquals("Pacific", ocean.getOcean_name());
    }
}