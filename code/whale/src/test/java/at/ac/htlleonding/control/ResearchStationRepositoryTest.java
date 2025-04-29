package at.ac.htlleonding.control;

import at.ac.htlleonding.model.ResearchStation;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class ResearchStationRepositoryTest {

    @Inject
    ResearchStationRepository stationRepository;

    @Inject
    OceanRepository oceanRepository;

    @Test
    @Transactional
    void testFindClosestResearchSite() {
        ResearchStation station1 = new ResearchStation("Station A", 10.0, 10.0);
        stationRepository.persist(station1);

        ResearchStation station2 = new ResearchStation("Station B", 20.0, 20.0);
        stationRepository.persist(station2);

        ResearchStation closest = stationRepository.findClosestResearchSite(10.5, 10.5);
        assertThat(closest).isNotNull();
        assertThat(closest.getResearchStationName()).isEqualTo("Station A");
    }
}
