package yunya.findproff.services;

import org.springframework.stereotype.Service;
import yunya.findproff.models.Review;

import java.util.List;

@Service
public interface ReviewService {

    void addReview(Review review);

    void deleteReviewById(int id);

    List<Review> getReviews();
}
