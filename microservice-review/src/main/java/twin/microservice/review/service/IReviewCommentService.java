package twin.microservice.review.service;

import twin.microservice.review.entity.Review;
import twin.microservice.review.entity.ReviewComment;

import java.util.List;
import java.util.Map;

public interface IReviewCommentService {
    public List<ReviewComment> getAllReviewComments();
    public ReviewComment getReviewCommentById(Long idReviewComment);
    public ReviewComment createReviewComment(ReviewComment reviewComment);
    public ReviewComment updateReviewComment(ReviewComment reviewComment);
    public void deleteReviewComment(Long idReviewComment);
    public List<ReviewComment> getReviewCommentsByVehicleId(Long vehicleId);
    public List<ReviewComment> getReviewCommentsByUserId(Long userId);

    public long countCommentsByVehicleId(Long vehicleId);
    public long countCommentsByUserId(Long userId);
    public List<ReviewComment> searchCommentsByKeyword(String keyword);
    Map<Review, Long> countReviewsByTypeAndVehicleId(Long vehicleId);








}

