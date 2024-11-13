package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunya.findproff.models.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
