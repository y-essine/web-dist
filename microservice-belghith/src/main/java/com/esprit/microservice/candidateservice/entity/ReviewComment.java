package com.esprit.microservice.candidateservice.entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ReviewComment")
public class ReviewComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idReviewComment")
    private Long idReviewComment;
    private Long vehicleId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Review review;
    private String text;
    private Date createdAt;
}
