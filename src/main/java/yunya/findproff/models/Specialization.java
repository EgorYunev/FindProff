package yunya.findproff.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Override
    public String toString() {
        return "Specialization{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
