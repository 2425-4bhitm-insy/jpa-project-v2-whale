package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.WhaleTrackerRepository;
import at.ac.htlleonding.model.Whale;
import at.ac.htlleonding.model.WhaleTrackerHistory;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/tracker")
public class WhaleTrackerResource {
    @Inject
    WhaleTrackerRepository trackerRepository;
    @Inject
    WhaleTrackerRepository whaleTrackerRepository;

    @GET
    public Response getAllTrackers() {
        return Response.ok(trackerRepository.findAll()).build();
    }

    @POST
    public Response addTracker(WhaleTrackerHistory tracker) {
        trackerRepository.persist(tracker);
        return Response.ok(trackerRepository.isPersistent(tracker)).build();
    }

    @GET
    public Response getTrackerDataForWhale(@QueryParam("whale") Whale whale) {
        return Response.ok(trackerRepository.getTrackerHistory(whale)).build();
    }
}
