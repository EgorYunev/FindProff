package yunya.findproff.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Builder
@Data
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String email;

    private String password;

    private boolean isWorker;

    @OneToOne(targetEntity = Worker.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Worker worker;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

}
