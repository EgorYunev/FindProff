package yunya.findproff.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String email;

    private String password;


    @OneToOne(targetEntity = Worker.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Worker worker;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    private String roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
