package yunya.findproff.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
