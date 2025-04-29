package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.WhaleRepository;
import at.ac.htlleonding.control.WhaleTrackerRepository;
import at.ac.htlleonding.control.WhaleTrackingCountRecord;
import at.ac.htlleonding.model.Whale;
import at.ac.htlleonding.model.WhaleTrackerHistory;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/tracker")
public class WhaleTrackerResource {

    @Inject
    WhaleTrackerRepository whaleTrackerRepository;

    @Inject
    WhaleRepository whaleRepository;

    @GET
    public Response getAllTrackers() {
        return Response.ok(whaleTrackerRepository.findAll()).build();
    }

    @POST
    public Response addTracker(WhaleTrackerHistory tracker) {
        whaleTrackerRepository.persist(tracker);
        return Response.ok(whaleTrackerRepository.isPersistent(tracker)).build();
    }

    @GET
    @Path("whale/{id}/tracker-data")
    public Response getTrackerDataForWhale(@PathParam("id") Long whaleId) {
        Whale whale = whaleRepository.findById(whaleId);
        return Response.ok(whaleTrackerRepository.getTrackerHistory(whale)).build();
    }

    @GET
    @Path("tracking-counts")
    @Produces("application/json")
    public Response getTrackingCountsGroupedByDate() {
        List<WhaleTrackingCountRecord> trackingCounts = whaleTrackerRepository.getTrackingCountsGroupedByDate();
        return Response.ok(trackingCounts).build();
    }

    @GET
    @Path("/tracked-for-minimum-days")
    public Response getWhalesTrackedForMinimumDays(@QueryParam("minDays") int minDays) {
        if (minDays <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("minDays must be a positive integer.")
                    .build();
        }

        List<WhaleTrackingCountRecord> whaleTrackingRecords = whaleTrackerRepository.getWhalesTrackedForMinimumDays(minDays);

        if (whaleTrackingRecords.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("no whales found with the given minimum tracking days.")
                    .build();
        }

        return Response.ok(whaleTrackingRecords).build();
    }
}