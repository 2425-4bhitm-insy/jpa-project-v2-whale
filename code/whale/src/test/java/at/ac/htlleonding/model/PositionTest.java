package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testPositionGettersAndSetters() {
        Position position = new Position(10.0, 20.0);

        assertEquals(10.0, position.getLat());
        assertEquals(20.0, position.getLon());
    }
}