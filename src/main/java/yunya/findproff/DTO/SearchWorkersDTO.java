package yunya.findproff.DTO;

import lombok.Data;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;

@Data
public class SearchWorkersDTO {

    City city;

    Specialization specialization;

}
