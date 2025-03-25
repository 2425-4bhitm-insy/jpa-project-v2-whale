package at.ac.htlleonding.control;

import at.ac.htlleonding.model.ConservationStatus;
import at.ac.htlleonding.model.Ocean;
import at.ac.htlleonding.model.Whale;

import java.util.List;

public class WhaleRepository {
    public void addWhale(Whale whaleToAdd){
    }
    public boolean removeWhale(Whale whaleToRemove){
        return false;
    }
    public boolean updateWhale(Whale whaleToUpdate){
        return false;
    }
    public List<Whale> getWhalesByOcean(Ocean ocean){
        return null;
    }
    public List<Whale> getWhalesByConservationStatus(ConservationStatus conservationStatus){
        return null;
    }
}
