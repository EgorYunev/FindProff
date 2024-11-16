package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunya.findproff.models.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
}