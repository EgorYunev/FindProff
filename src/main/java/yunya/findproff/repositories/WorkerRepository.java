package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yunya.findproff.models.City;
import yunya.findproff.models.Specialization;
import yunya.findproff.models.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Optional<Worker> findById(int id);
    Optional<Worker> findByUser_Username(String username);
    List<Worker> findWorkersBySpecializationAndCity(Specialization specialization, City city);
}
