package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.WhaleRepository;
import at.ac.htlleonding.control.WhaleTrackerRepository;
import at.ac.htlleonding.model.Whale;
import at.ac.htlleonding.model.WhaleTrackerHistory;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

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
}
