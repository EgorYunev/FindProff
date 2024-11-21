package yunya.findproff.DTO;

import lombok.Data;
import yunya.findproff.models.Worker;

@Data
public class RequestDTO {

    int cityId;

    int specId;

    String text;

}
