package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.OceanRepository;
import at.ac.htlleonding.control.ResearchStationRepository;
import at.ac.htlleonding.control.ResearchStationType;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.ResearchStation;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/stations")
public class ResearchStationResource {
    @Inject
    ResearchStationRepository stationRepository;
    @Inject
    OceanRepository oceanRepository;

    @GET
    public Response getAllResearchStations() {
        return Response.ok(stationRepository.findAll()).build();
    }

    @POST
    public Response addResearchStation(ResearchStation researchStation) {
        stationRepository.persist(researchStation);
        return Response.ok(stationRepository.isPersistent(researchStation)).build();
    }

    @GET
    @Path("ocean/{id}")
    public Response getResearchStationsByOcean(@PathParam("id") Long oceanId) {
        Ocean ocean = oceanRepository.findById(oceanId);
        return Response.ok(stationRepository.getResearchStationsByOcean(ocean)).build();
    }
}
