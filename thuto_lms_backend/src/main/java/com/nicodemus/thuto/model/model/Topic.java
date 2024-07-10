package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String topicName;
    private String topicPDF;

    // relationships
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
