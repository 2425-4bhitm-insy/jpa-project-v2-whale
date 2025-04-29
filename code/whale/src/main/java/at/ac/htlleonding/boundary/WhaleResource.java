package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.OceanRepository;
import at.ac.htlleonding.control.WhaleRepository;
import at.ac.htlleonding.model.ConservationStatus;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.Whale;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/whales")
public class WhaleResource {
    @Inject
    WhaleRepository whaleRepository;

    @Inject
    OceanRepository oceanRepository;

    @GET
    public Response getAllWhales(){
        return Response.ok(whaleRepository.findAll()).build();
    }
    @POST
    public Response addWhale(Whale whale) {
        whaleRepository.persist(whale);
        return Response.ok(whaleRepository.isPersistent(whale)).build();
    }

    @GET
    @Path("conservation/status")
    public Response getWhalesByConservationStatus(@QueryParam("conservation-status") ConservationStatus conservationStatus){
        return Response.ok(whaleRepository.getWhalesByConservationStatus(conservationStatus)).build();
    }
}
