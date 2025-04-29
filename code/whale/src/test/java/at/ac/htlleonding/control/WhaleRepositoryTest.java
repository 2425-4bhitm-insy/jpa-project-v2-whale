package at.ac.htlleonding.control;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

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
