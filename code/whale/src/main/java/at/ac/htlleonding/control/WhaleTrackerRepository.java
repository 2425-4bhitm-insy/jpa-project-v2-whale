package at.ac.htlleonding.control;

import at.ac.htlleonding.model.ResearchSite;
import at.ac.htlleonding.model.Whale;
import at.ac.htlleonding.model.WhaleTrackerHistory;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.TypedQuery;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class WhaleTrackerRepository implements PanacheRepository<WhaleTrackerHistory> {

    public static final int EARTH_RADIUS = 6371;

    @Inject
    WhaleRepository whaleRepository;

    public List<WhaleTrackerHistory> getTrackerHistory(Whale whale) {
        return find("whale", whale).list();
    }

    public int getDistanceTravelledInKm(Whale whale, LocalDateTime from, LocalDateTime to) {
        int distance = 0;

        for (WhaleTrackerHistory history : getTrackerHistory(whale)) {
            if (history.getTimestamp().after(Timestamp.valueOf(from)) &&
                history.getTimestamp().before(Timestamp.valueOf(to))) {
                distance += calculateDistance(history.getPosition().getLat(), history.getPosition().getLon(), history.getPosition().getLat(), history.getPosition().getLon());
            }
        }

        return distance;
    }

    static int calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        double distance = Math.sqrt(x * x + y * y) * EARTH_RADIUS;

        return (int) Math.round(distance);
    }

    public ResearchSite getLastVisitedSite(Whale whale) {
        final int RANGE = 10;

        TypedQuery<ResearchSite> typedQuery = this.getEntityManager().createQuery(
                "select r from ResearchSite r " +
                        "join WhaleTrackerHistory wH " +
                        "on wh.whale.id = :whaleId " +
                        "where SQRT( " +
                        "  POWER( " +
                        "    RADIANS(wh.position.lat) - RADIANS(r.position.lat) " +
                        "  ) + " +
                        "  POWER( " +
                        "    (RADIANS(wh.position.lon) - RADIANS(r.position.lon)) * COS(RADIANS((wh.position.lat + r.position.lat) / 2)) " +
                        "  ) " +
                        ") * :earthRadius < :range " +
                        "order by wh.timestamp desc "
                , ResearchSite.class
        );

        typedQuery.setParameter("whaleId", whale.getId());
        typedQuery.setParameter("earthRadius", EARTH_RADIUS);
        typedQuery.setParameter("range", RANGE);

        return typedQuery.getSingleResult();
    }

    public List<WhaleTrackingCountRecord> getTrackingCountsGroupedByDate() {
        TypedQuery<WhaleTrackingCountRecord> query = getEntityManager().createQuery(
                "SELECT new at.ac.htlleonding.control.WhaleTrackingCountRecord(" +
                        " w.whale.id, FUNCTION('DATE', w.timestamp), COUNT(w)) " +
                        "FROM WhaleTrackerHistory w " +
                        "GROUP BY w.whale.id, FUNCTION('DATE', w.timestamp) " +
                        "ORDER BY w.whale.id, FUNCTION('DATE', w.timestamp)",
                WhaleTrackingCountRecord.class
        );

        return query.getResultList();
    }

    public List<WhaleTrackingCountRecord> getWhalesTrackedForMinimumDays(int minDays) {
        TypedQuery<WhaleTrackingCountRecord> query = getEntityManager().createQuery(
                "SELECT new at.ac.htlleonding.control.WhaleTrackingCountRecord(" +
                        "w.whale.id, FUNCTION('DATE', w.timestamp), COUNT(w)) " +
                        "FROM WhaleTrackerHistory w " +
                        "GROUP BY w.whale.id, FUNCTION('DATE', w.timestamp) " +
                        "HAVING COUNT(w) >= :minDays " +
                        "ORDER BY w.whale.id, FUNCTION('DATE', w.timestamp)",
                WhaleTrackingCountRecord.class
        );

        query.setParameter("minDays", minDays);

        return query.getResultList();
    }
}
