package yunya.findproff.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Worker> workers;

    @OneToMany(mappedBy = "city")
    private List<Request> requests;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
