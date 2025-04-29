package at.ac.htlleonding.control;

import at.ac.htlleonding.model.ConservationStatus;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.Whale;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class WhaleRepository implements PanacheRepository<Whale> {

    public List<Whale> getWhalesByConservationStatus(ConservationStatus conservationStatus) {
        return find("conservationStatus", conservationStatus).list();
    }
}
