package at.ac.htlleonding.control;

import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.ResearchStation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ResearchStationRepository implements PanacheRepository<ResearchStation> {
    public List<ResearchStation> getResearchStationsByType(ResearchStationType type) {
        return find("type", type).list();
    }

    public List<ResearchStation> getResearchStationsByOcean(Ocean ocean) {//might cause problem, not all stations have an ocean
        return find("ocean", ocean).list();
    }

    public ResearchStation findClosestResearchSite(double lat, double lon) {
        double minDistance = Double.MAX_VALUE;
        ResearchStation closestStation = null;

        for (ResearchStation station : listAll()) {
            double distance = WhaleTrackerRepository.calculateDistance(
                    lat,
                    lon,
                    station.getStationId().getLat(),
                    station.getStationId().getLon()
            );

            if (distance < minDistance) {
                minDistance = distance;
                closestStation = station;
            }
        }
        return closestStation;
    }
}
