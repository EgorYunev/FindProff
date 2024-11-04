package yunya.findproff.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import yunya.findproff.models.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {
}
