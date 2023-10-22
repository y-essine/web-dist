package com.esprit.microservice.candidateservice.controller;


import com.esprit.microservice.candidateservice.entity.Review;
import com.esprit.microservice.candidateservice.entity.ReviewComment;
import com.esprit.microservice.candidateservice.service.IReviewCommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/review")

public class ReviewCommentController {

    IReviewCommentService reviewCommentService;

    @GetMapping("/all")
    public List<ReviewComment> getAllReviewComments(){
        return reviewCommentService.getAllReviewComments();
    }

    @GetMapping("/getReviewCommentById/{idReviewComment}")
    public ReviewComment getReviewCommentById(@PathVariable("idReviewComment") Long idReviewComment){
       return reviewCommentService.getReviewCommentById(idReviewComment);
    }

    @PostMapping("/addReviewComment")
    public ReviewComment addReviewComment(@RequestBody ReviewComment reviewComment) {
        return reviewCommentService.createReviewComment(reviewComment);
    }

    @PutMapping("/updatereviewComment")
    public ReviewComment updateReviewComment(@RequestBody ReviewComment reviewComment){
        return reviewCommentService.updateReviewComment(reviewComment);
    }

    @DeleteMapping("/deleteReviewComment/{idReviewComment}")
    public void deleteReviewComment(@PathVariable("idReviewComment") Long idReviewComment){
        reviewCommentService.deleteReviewComment(idReviewComment);
    }
    @GetMapping("/getReviewCommentsByVehicleId/{vehicleId}")
    public List<ReviewComment> getReviewCommentsByVehicleId(@PathVariable("vehicleId") Long vehicleId) {
        return reviewCommentService.getReviewCommentsByVehicleId(vehicleId);
    }
    @GetMapping("/getReviewCommentsByUserId/{userId}")
    public List<ReviewComment> getReviewCommentsByUserId(@PathVariable("userId") Long userId) {
        return reviewCommentService.getReviewCommentsByUserId(userId);
    }

    @GetMapping("/count/byVehicle/{vehicleId}")
    public long countCommentsByVehicleId(@PathVariable Long vehicleId) {
        return reviewCommentService.countCommentsByVehicleId(vehicleId);
    }

    @GetMapping("/count/byUser/{userId}")
    public long countCommentsByUserId(@PathVariable Long userId) {
        return reviewCommentService.countCommentsByUserId(userId);
    }

    @GetMapping("/search")
    public List<ReviewComment> searchCommentsByKeyword(@RequestParam String keyword) {
        return reviewCommentService.searchCommentsByKeyword(keyword);
    }

    @GetMapping("/count/review-types/{vehicleId}")
    public Map<Review, Long> countReviewsByTypeAndVehicleId(@PathVariable Long vehicleId) {
        return reviewCommentService.countReviewsByTypeAndVehicleId(vehicleId);
    }

}
