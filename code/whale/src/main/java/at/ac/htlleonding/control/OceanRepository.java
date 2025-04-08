package at.ac.htlleonding.control;

import at.ac.htlleonding.model.Ocean;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OceanRepository implements PanacheRepository<Ocean> {
}
