package at.ac.htlleonding.control;

import at.ac.htlleonding.model.ResearchSite;
import at.ac.htlleonding.model.Whale;
import at.ac.htlleonding.model.WhaleTrackerHistory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class WhaleTrackerRepository {
    public List<WhaleTrackerHistory> getTrackerHistory(Whale whale) {
        return null;
    }

    public int getDistanceTravelledInKm(Whale whale, LocalDateTime from, LocalDateTime to) {
        return -1;
    }

    public ResearchSite getLastVisitedSite(Whale whale) { //Checks when the position of a whale last matched a research station's one
        return null;
    }
}
