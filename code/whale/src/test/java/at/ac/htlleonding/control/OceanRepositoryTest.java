package at.ac.htlleonding.control;

import at.ac.htlleonding.model.Ocean;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class OceanRepositoryTest {

    @Inject
    OceanRepository oceanRepository;

    @Test
    void testRepositoryIsNotNull() {
        assertThat(oceanRepository).isNotNull();
    }
}
