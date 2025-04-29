package at.ac.htlleonding.control;

import at.ac.htlleonding.model.*;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class WhaleTrackerRepositoryTest {

    @Inject
    WhaleTrackerRepository trackerRepository;

    @Inject
    WhaleRepository whaleRepository;

    @Test
    void testDistanceCalculationStaticMethod() {
        int distance = WhaleTrackerRepository.calculateDistance(0, 0, 0, 1);
        assertThat(distance).isGreaterThan(0);
    }

    @Test
    @Transactional
    void testGetTrackerHistoryAndDistanceTravelled() {
        ConservationStatus conservationStatus = new ConservationStatus("status");
        whaleRepository.getEntityManager().persist(conservationStatus); // Persist ConservationStatus first

        Whale whale = new Whale("whaleName");
        whale.setConservationStatus(conservationStatus); // Associate persisted ConservationStatus
        whaleRepository.persist(whale);

        WhaleTrackerHistory history = new WhaleTrackerHistory();
        history.setWhale(whale);

        Position position = new Position(10.0, 20.0);
        history.setPosition(position);

        history.setTimestamp(Timestamp.valueOf(LocalDateTime.now().minusHours(1)));
        trackerRepository.persist(history);

        List<WhaleTrackerHistory> result = trackerRepository.getTrackerHistory(whale);
        assertThat(result).isNotEmpty();

        int distance = trackerRepository.getDistanceTravelledInKm(
                whale,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now()
        );
        assertThat(distance).isGreaterThanOrEqualTo(0);
    }
}
