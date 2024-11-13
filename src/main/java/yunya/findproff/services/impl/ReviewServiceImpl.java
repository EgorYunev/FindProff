package yunya.findproff.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yunya.findproff.models.Review;
import yunya.findproff.models.User;
import yunya.findproff.repositories.ReviewRepo;
import yunya.findproff.repositories.UserRepo;
import yunya.findproff.services.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    private final UserRepo userRepo;

    @Override
    public void addReview(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void deleteReviewById(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<Review> getReviewsByUsername(String username) {
        Optional<User> op = userRepo.findByUsername(username);
        if (op.isPresent()) {
            return op.get().getReviews();
        } else {
            throw new RuntimeException("User cannot found " + username);
        }
    }
}
