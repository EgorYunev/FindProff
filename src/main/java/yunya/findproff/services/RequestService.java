package yunya.findproff.services;

import org.springframework.stereotype.Service;
import yunya.findproff.models.Request;

import java.util.List;

@Service
public interface RequestService {

    Request getRequestById(int id);

    List<Request> getRequestsByCityAndSpec(int cityId, int specId);

    void addRequest(Request request);

    List<Request> getRequestsByUsername(String username);

    List<Request> getRequestsByUserId(int id);

}
