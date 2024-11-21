package yunya.findproff.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yunya.findproff.models.Request;
import yunya.findproff.models.User;
import yunya.findproff.repositories.RequestRepo;
import yunya.findproff.repositories.UserRepo;
import yunya.findproff.services.RequestService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepo requestRepo;

    private final UserRepo userRepo;


    @Override
    public Request getRequestById(int id) {
        Optional<Request> op = requestRepo.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<Request> getRequestsByCityAndSpec(int cityId, int specId) {
        List<Request> requests = requestRepo.getRequestsByCity_IdAndSpecialization_Id(cityId, specId);
        for (int i = 0; i < requests.size(); i++) {
            Request request = requests.get(i);
            if (request.getWorker() != null) {
                requests.remove(i);
            }
        }
        return requests;
    }

    @Override
    public void addRequest(Request request) {
        requestRepo.save(request);
    }

    @Override
    public List<Request> getRequestsByUsername(String username) {
        Optional<User> op = userRepo.findByUsername(username);
        if (op.isPresent()) {
            return op.get().getRequests();
        } else {
            throw new RuntimeException("Username cannot found " + username);
        }
    }

    @Override
    public List<Request> getRequestsByUserId(int id) {
        return List.of();
    }
}
