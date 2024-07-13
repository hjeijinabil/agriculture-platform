package com.agriculture_platform.ReviewFeedback.Controller;

import com.agriculture_platform.ReviewFeedback.Entity.Feedback;
import com.agriculture_platform.ReviewFeedback.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }

    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}
