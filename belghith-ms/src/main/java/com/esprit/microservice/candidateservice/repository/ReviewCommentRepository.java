package com.esprit.microservice.candidateservice.repository;

import com.esprit.microservice.candidateservice.entity.Review;
import com.esprit.microservice.candidateservice.entity.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Long> {
    List<ReviewComment> findByVehicleId(Long vehicleId);
    List<ReviewComment> findByUserId(Long userId);
    long countByVehicleId(Long vehicleId);
    long countByUserId(Long userId);

    @Query("SELECT c FROM ReviewComment c WHERE c.text LIKE %:keyword%")
    List<ReviewComment> findByTextContaining(String keyword);

    @Query("SELECT c.review, COUNT(c) FROM ReviewComment c WHERE c.vehicleId = :vehicleId GROUP BY c.review")
    List<Object[]> countReviewsByTypeAndVehicleIdGrouped(@Param("vehicleId") Long vehicleId);

    default Map<Review, Long> countReviewsByTypeAndVehicleId(@Param("vehicleId") Long vehicleId) {
        List<Object[]> results = countReviewsByTypeAndVehicleIdGrouped(vehicleId);

        return results.stream()
                .collect(Collectors.toMap(
                        result -> (Review) result[0],
                        result -> (Long) result[1]
                ));
    }
}