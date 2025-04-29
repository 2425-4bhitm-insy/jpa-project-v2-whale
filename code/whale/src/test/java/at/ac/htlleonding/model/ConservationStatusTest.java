package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConservationStatusTest {

    @Test
    public void testConservationStatusGettersAndSetters() {
        ConservationStatus status = new ConservationStatus("Endangered");

        assertEquals("Endangered", status.getStatus_name());
    }
}