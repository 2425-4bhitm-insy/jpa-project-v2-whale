package at.ac.htlleonding.model;

import at.ac.htlleonding.model.*;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class WhaleTrackerHistoryTest {

    @Test
    public void testWhaleTrackerHistoryGettersAndSetters() {
        Whale whale = new Whale("Blue Whale");
        Ocean ocean = new Ocean("Pacific");
        Position position = new Position(10.0, 20.0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        WhaleTrackerHistory history = new WhaleTrackerHistory();
        history.setWhale(whale);
        history.setOcean(ocean);
        history.setPosition(position);
        history.setTimestamp(timestamp);

        assertEquals(whale, history.getWhale());
        assertEquals(ocean, history.getOcean());
        assertEquals(position, history.getPosition());
        assertEquals(timestamp, history.getTimestamp());
    }
}