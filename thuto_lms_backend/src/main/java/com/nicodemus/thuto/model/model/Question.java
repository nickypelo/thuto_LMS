package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionName;
    private String studentAnswer;
    private String answer;

    // relationships
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
