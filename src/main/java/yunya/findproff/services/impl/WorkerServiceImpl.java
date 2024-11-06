package yunya.findproff.services.impl;

import org.springframework.stereotype.Service;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;
import yunya.findproff.models.Worker;
import yunya.findproff.repositories.WorkerRepository;
import yunya.findproff.services.WorkerService;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public void addWorker(Worker worker) {
        workerRepository.save(worker);
    }

    @Override
    public Worker getWorkerById(int id) {
        Optional<Worker> op = workerRepository.findById(id);
        return op.orElse(null);
    }

    @Override
    public Worker getWorkerByUsername(String username) {
        Optional<Worker> op = workerRepository.findByUser_Username(username);
        return op.orElse(null);
    }

    @Override
    public List<Worker> getWorkersBySpecializationAndCity(Specialization specialization, City city) {
        return workerRepository.findWorkersBySpecializationAndCity(specialization, city);
    }
}
