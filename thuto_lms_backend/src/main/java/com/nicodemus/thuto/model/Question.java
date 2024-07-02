package com.nicodemus.thuto.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
@EntityListeners(AuditingEntityListener.class)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionSet;
    private String answerProvided;
    private String answerSet;

    // relationships
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
