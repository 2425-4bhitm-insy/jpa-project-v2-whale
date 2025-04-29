package at.ac.htlleonding.control;

import at.ac.htlleonding.model.ConservationStatus;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.Whale;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class WhaleRepositoryTest {

    @Inject
    WhaleRepository whaleRepository;

    @Test
    void testRepositoryIsNotNull() {
        assertThat(whaleRepository).isNotNull();
    }
}
