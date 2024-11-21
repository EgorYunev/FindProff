package yunya.findproff.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunya.findproff.models.Request;

import java.util.List;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {
    List<Request> getRequestsByCity_IdAndSpecialization_Id(int id, int id1);
}
