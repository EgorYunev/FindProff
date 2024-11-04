package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yunya.findproff.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
