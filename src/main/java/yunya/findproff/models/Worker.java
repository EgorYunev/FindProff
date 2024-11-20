package yunya.findproff.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Worker {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "worker")
    private User user;

    @OneToMany(mappedBy = "worker")
    private List<Review> reviews;

    @ManyToOne(targetEntity = Specialization.class)
    private Specialization specialization;

    @ManyToOne(targetEntity = City.class)
    private City city;

    @OneToMany(mappedBy = "worker")
    private List<Request> requests;


}
