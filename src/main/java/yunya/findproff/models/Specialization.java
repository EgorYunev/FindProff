package yunya.findproff.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Specialization {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Worker> workers;

}
