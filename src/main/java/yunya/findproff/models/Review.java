package yunya.findproff.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", evaluation=" + evaluation +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
