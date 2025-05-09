package at.ac.htlleonding.control;

import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.ResearchStation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ResearchStationRepository implements PanacheRepository<ResearchStation> {
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
                    station.getPosition().getLat(),
                    station.getPosition().getLon()
            );

            if (distance < minDistance) {
                minDistance = distance;
                closestStation = station;
            }
        }
        return closestStation;
    }
}
