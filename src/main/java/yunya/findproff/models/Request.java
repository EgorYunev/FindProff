package yunya.findproff.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Worker.class)
    private Worker worker;

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", user=" + user +
                ", worker=" + worker +
                '}';
    }
}
