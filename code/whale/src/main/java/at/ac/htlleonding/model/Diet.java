package at.ac.htlleonding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diet_id;

    private String diet_name;

    public Diet() {
    }

    public Diet(String diet_name) {
        this.diet_name = diet_name;
    }

    public String getDiet_name() {
        return diet_name;
    }

    public void setDiet_name(String diet_name) {
        this.diet_name = diet_name;
    }
}
