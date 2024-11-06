package yunya.findproff.services;

import org.springframework.stereotype.Service;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;
import yunya.findproff.models.Worker;

import java.util.List;

@Service
public interface WorkerService {

    void addWorker(Worker worker);

    Worker getWorkerById(int id);

    Worker getWorkerByUsername(String username);

    List<Worker> getWorkersBySpecializationAndCity(Specialization specialization, City city);

}
