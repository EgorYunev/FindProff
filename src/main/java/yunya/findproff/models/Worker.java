package yunya.findproff.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Worker {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "worker")
    private User user;

    @OneToMany(mappedBy = "worker")
    private List<Review> reviews;

    private Specialization specialization;

    private City city;

    @OneToMany(mappedBy = "worker")
    private List<Request> requests;

}
