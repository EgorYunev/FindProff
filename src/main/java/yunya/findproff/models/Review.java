package yunya.findproff.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private int id;

    private double evaluation;

    private String text;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Worker.class)
    private Worker worker;

}
