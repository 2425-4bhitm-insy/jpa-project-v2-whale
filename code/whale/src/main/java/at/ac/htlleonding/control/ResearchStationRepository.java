package at.ac.htlleonding.control;

import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.ResearchStation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class ResearchStationRepository implements PanacheRepository<ResearchStation> {
    public List<ResearchStation> getResearchStationsByType(ResearchStationType type) {
        return find("type", type).list();
    }

    public List<ResearchStation> getResearchStationsByOcean(Ocean ocean) {
        return find("ocean", ocean).list();
    }

    public ResearchStation findClosestResearchSite(double lat, double lon) {
        return null;
    }
}
