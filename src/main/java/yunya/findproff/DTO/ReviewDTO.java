package yunya.findproff.DTO;


import lombok.Data;
import yunya.findproff.models.User;
import yunya.findproff.models.Worker;

@Data
public class ReviewDTO {

    double evaluation;

    String text;

    User user;

    Worker worker;


}
