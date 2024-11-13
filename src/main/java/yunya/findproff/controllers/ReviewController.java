package yunya.findproff.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yunya.findproff.DTO.ReviewDTO;
import yunya.findproff.models.Review;
import yunya.findproff.models.User;
import yunya.findproff.services.ReviewService;
import yunya.findproff.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    private final UserService userService;

    @PostMapping("/add")
    public String addReview(@ModelAttribute ReviewDTO dto, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());

        Review review = Review.builder()
                .text(dto.getText())
                .worker(dto.getWorker())
                .evaluation(dto.getEvaluation())
                .build();
        reviewService.addReview(review);
        return "success";
    }

    @GetMapping("/get-reviews-by-username/{username}")
    public String getReviewsByUsername(@RequestParam String username, Model model) {
        User user = userService.getUserByUsername(username);
        model.addAttribute(user.getReviews());
        return "reviews";
    }

}
