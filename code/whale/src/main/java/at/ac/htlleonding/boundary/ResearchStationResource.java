package at.ac.htlleonding.boundary;

import at.ac.htlleonding.control.ResearchStationRepository;
import at.ac.htlleonding.control.ResearchStationType;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.ResearchStation;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/stations")
public class ResearchStationResource {
    @Inject
    ResearchStationRepository stationRepository;

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
    public Response getResearchStationsByType(@QueryParam("type") ResearchStationType type) {
        return Response.ok(stationRepository.getResearchStationsByType(type)).build();
    }

    @GET
    public Response getResearchStationsByOcean(@QueryParam("ocean") Ocean ocean) {
        return Response.ok(stationRepository.getResearchStationsByOcean(ocean)).build();
    }
}
