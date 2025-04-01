package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.WhaleRepository;
import at.ac.htlleonding.model.ConservationStatus;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.Whale;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/whales")
public class WhaleResource {
    @Inject
    WhaleRepository whaleRepository;
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
    public Response getWhalesPerOcean(@QueryParam("ocean") Ocean ocean){
        return Response.ok(whaleRepository.getWhalesByOcean(ocean)).build();
    }
    @GET
    public Response getWhalesByConservationStatus(@QueryParam("conservation-status") ConservationStatus conservationStatus){
        return Response.ok(whaleRepository.getWhalesByConservationStatus(conservationStatus)).build();
    }
}
