package yunya.findproff.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Worker> workers;

}
