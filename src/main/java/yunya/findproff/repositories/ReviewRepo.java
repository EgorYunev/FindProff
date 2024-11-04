package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yunya.findproff.models.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
