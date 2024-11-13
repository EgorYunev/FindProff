package yunya.findproff.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunya.findproff.models.Request;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {
}
