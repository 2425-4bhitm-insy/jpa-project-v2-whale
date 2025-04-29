package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DietTest {

    @Test
    public void testDietGettersAndSetters() {
        Diet diet = new Diet("Krill");

        assertEquals("Krill", diet.getDiet_name());
    }
}