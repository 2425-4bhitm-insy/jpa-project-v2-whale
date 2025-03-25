package at.ac.htlleonding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ConservationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long status_id;

    String status_name;

    public ConservationStatus() {

    }

    public ConservationStatus(String status_name) {
        this.status_name = status_name;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }


}
