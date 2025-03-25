package at.ac.htlleonding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ocean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ocean_id;

    private String ocean_name;

    public Ocean() {
    }

    public Ocean(String ocean_name) {
        this.ocean_name = ocean_name;
    }

    public Long getOcean_id() {
        return ocean_id;
    }

    public String getOcean_name() {
        return ocean_name;
    }

    public void setOcean_name(String ocean_name) {
        this.ocean_name = ocean_name;
    }
}
