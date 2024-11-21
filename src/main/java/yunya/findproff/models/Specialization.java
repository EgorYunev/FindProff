package yunya.findproff.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Specialization {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Worker> workers;

    @OneToMany(mappedBy = "specialization")
    private List<Request> requests;

    @Override
    public String toString() {
        return "Specialization{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
